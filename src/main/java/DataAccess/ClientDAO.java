package DataAccess;
import Connection.ConnectionFactory;
import Model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ClientDAO extends AbstractDAO<Client>{
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    public ClientDAO(){
        super("clients");
    }

    public void update(Client client){
        String s = "UPDATE clients SET name = ?, email = ?, age = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(s);
            statement.setString(1, client.getName());
            statement.setString(2,client.getEmail());
            statement.setInt(3,client.getAge());
            statement.setInt(4,client.getId());

            statement.executeQuery();
            System.out.println("Update succesfull");
        } catch (SQLException e){
            LOGGER.severe("ERROR executing SQL query: " + e.getMessage());
        } finally{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
    }

    public void delete(Client client){
        String s = "DELETE FROM clients WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{

            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(s);
            statement.setInt(1,client.getId());

            statement.executeQuery();
            System.out.println("Delete succesfull");
        } catch (SQLException e){
            LOGGER.severe("ERROR executing SQL query: " + e.getMessage());
        } finally{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
    }

    public void insert(Client client){
        String s = "INSERT INTO clients (id,name,email,age)";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{

            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(s);

            statement.setInt(1,client.getId());
            statement.setString(2,client.getName());
            statement.setString(3,client.getEmail());
            statement.setInt(4,client.getAge());

            statement.executeUpdate();
            System.out.println("Insertion succesfull");
        } catch (SQLException e){
            LOGGER.severe("ERROR executing SQL query: " + e.getMessage());
        } finally{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
    }

}
