package Connection;

import java.sql.*;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost/tema3pt";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    private ConnectionFactory(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection(){
            Connection connection = null;
            try{
                connection = DriverManager.getConnection(DBURL, USER, PASS);
            } catch (SQLException e) {
               LOGGER.severe("Error al creating connection to database" + e.getMessage());
            }
            return connection;
    }

    private static Connection getConnection(){
            return singleInstance.createConnection();
    }

    private static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.severe("Error at closing connection to database " + e.getMessage());
            }
        }
    }
    private static void close(Statement statement){
            if(statement != null){
                try{
                    statement.close();
                } catch(SQLException e){
                    LOGGER.severe("Error at closing statement" + e.getMessage());
                }
            }
    }

    private static void close(ResultSet resultSet){
            if(resultSet != null){
                try{
                    resultSet.close();
                } catch(SQLException e){
                    LOGGER.severe("Error at closing the result" + e.getMessage());
                }
            }
    }
}
