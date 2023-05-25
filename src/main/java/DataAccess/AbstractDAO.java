package DataAccess;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Constructor;

import Connection.ConnectionFactory;
/**
 * This class is used to return every row from the table in WorkBench.
 * This class uses the reflexion method to get all elements from the table;
 *
 * @author Elecfi Sergiu - Andrei 30223
 * @date 25.05.2023
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private String table;
    public AbstractDAO(String table){
        this.table = table;
    }

    public List<T> getAll(){
        List<T> sir = new ArrayList<>();
        String query = "SELECT * FROM " + table;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(query);
            rs = statement.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int col = metaData.getColumnCount();
            while(rs.next()){
                T x = createInstance();
                for(int i = 1; i <= col; i++){
                    String colName = metaData.getColumnName(i);
                    Object colValue = rs.getObject(i);
                    setFieldValue(x,colName,colValue);
                }
                sir.add(x);
            }
        } catch(SQLException e){
            LOGGER.severe("ERROR executing SQL query: " + e.getMessage());
        } finally{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
        return sir;
    }

    private T createInstance() {
        try {
            Class<T> cl = getGenericTypeClass();
            Constructor<T> constructor = cl.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + table, e);
        }
    }

    private void setFieldValue(T object, String fieldName, Object fieldValue){
        try{
            Class<?> cl = object.getClass();
            Field field = cl.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object,fieldValue);
        } catch (Exception e){
            throw new RuntimeException("Failed to set field value for " + fieldName, e);
        }
    }

    private Class<T> getGenericTypeClass(){
        try{
            return (Class<T>) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception e){
            throw new RuntimeException("Failed to get generic type class", e);
        }
    }
}
