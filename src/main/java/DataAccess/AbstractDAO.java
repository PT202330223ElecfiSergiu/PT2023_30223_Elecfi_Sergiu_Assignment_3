package DataAccess;
import Connection.ConnectionFactory;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class AbstractDAO<T> {
    private String table;
    private final Class<T> sir;
    public AbstractDAO(String table){
        this.sir = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.table = table;
    }

    public List<T> getAll(){
        List<T> sir = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String s = "SELECT * FROM " + table;

        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(s);
            rs = statement.executeQuery();
            while (rs.next()){
                T x = createObject(rs);
                sir.add(x);
            }
        } catch (SQLException | ReflectiveOperationException e){
            e.printStackTrace();
        } finally{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }

        return sir;
    }

    private T createObject(ResultSet rs) throws SQLException, ReflectiveOperationException{
        T aux = sir.getDeclaredConstructor().newInstance();
        Field[] fields = sir.getDeclaredFields();

        for(Field field : fields){
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = rs.getObject(fieldName);
            field.set(aux,value);
        }

        return aux;
    }

}
