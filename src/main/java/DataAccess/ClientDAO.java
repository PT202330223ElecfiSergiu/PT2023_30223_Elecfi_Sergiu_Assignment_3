package DataAccess;
import Connection.ConnectionFactory;
import Model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private final Connection conn;

    public ClientDAO(){

        this.conn = ConnectionFactory.getConnection();
    }

    public List<Client> getAll(){
        List<Client> clients = new ArrayList<>();
        String s = "SELECT * from Client";
        try(Statement statement = conn.prepareStatement(s); ResultSet rs = statement.executeQuery(s)) {
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                Client client = new Client(id,name,email,age);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void update(Client client){
        String s = "UPDATE clients SET name = ?, email = ?, age = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(s)) {
            statement.setString(1, client.getName());
            statement.setString(2,client.getEmail());
            statement.setInt(3,client.getAge());
            statement.setInt(4,client.getId());

            statement.executeQuery();
            System.out.println("Update succesfull");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Client client){
        String s = "DELETE FROM clients WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(s)) {
            statement.setInt(1,client.getId());

            statement.executeQuery();
            System.out.println("Delete succesfull");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(Client client){
        String s = "INSERT INTO clients (id,name,email,age)";

        try(PreparedStatement statement = conn.prepareStatement(s)){
            statement.setInt(1,client.getId());
            statement.setString(2,client.getName());
            statement.setString(3,client.getEmail());
            statement.setInt(4,client.getAge());

            statement.executeUpdate();
            System.out.println("Insertion succesfull");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
