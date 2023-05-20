package DataAccess;
import Connection.ConnectionFactory;
import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final Connection conn;

    public ProductDAO(){

        this.conn = ConnectionFactory.getConnection();
    }

    public List<Product> getAll(){
        List<Product> products = new ArrayList<>();
        String s = "SELECT * FROM products";
        try(Statement statement = conn.prepareStatement(s); ResultSet rs = statement.executeQuery(s)) {
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int stock  = rs.getInt("stock");
                int price = rs.getInt("price");

                Product product = new Product(id,name,stock,price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void update(Product product){
        String s = "UPDATE products SET name = ?, stock = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(s)) {
            statement.setString(1, product.getName());
            statement.setInt(2,product.getStock());
            statement.setInt(3,product.getPrice());
            statement.setInt(4,product.getId());

            statement.executeQuery();
            System.out.println("Update succesfull");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Product product){
        String s = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(s)) {
            statement.setInt(1,product.getId());

            statement.executeQuery();
            System.out.println("Delete succesfull");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(Product product){
        String s = "INSERT INTO products (id,name,stock,price)";

        try(PreparedStatement statement = conn.prepareStatement(s)){
            statement.setInt(1,product.getId());
            statement.setString(2,product.getName());
            statement.setInt(3,product.getStock());
            statement.setInt(4,product.getPrice());

            statement.executeUpdate();
            System.out.println("Insertion succesfull");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
