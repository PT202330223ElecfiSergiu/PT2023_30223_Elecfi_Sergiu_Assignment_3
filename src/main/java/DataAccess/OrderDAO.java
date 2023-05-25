package DataAccess;
import Connection.ConnectionFactory;
import Model.Order;
import java.sql.*;
import java.util.logging.Logger;

public class OrderDAO {
    protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());

    public OrderDAO() {
    }

    public void makeOrder(Order order) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectionFactory.getConnection();

            String getPrice = "SELECT price, stock FROM products where id = ?";
            preparedStatement = conn.prepareStatement(getPrice);
            preparedStatement.setInt(1, order.getIdProduct());
            resultSet = preparedStatement.executeQuery();

            int price = 0;
            int stock = 0;

            if (resultSet.next()) {
                price = resultSet.getInt("price");
                stock = resultSet.getInt("stock");
            }
            if (stock < order.getNr()) {
                System.out.println("Nu exista destule bucati pe stock!!!");
                return;
            }

            int pretTotal = order.getNr() * price;

            String insertQuery = "INSERT INTO orders (id,idproduct,idclient,nrofpieces,price) VALUES (?,?,?,?,?)";

            preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, order.getIdProduct());
            preparedStatement.setInt(3, order.getIdClient());
            preparedStatement.setInt(4, order.getNr());
            preparedStatement.setInt(5, pretTotal);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                String updateQuery = "UPDATE products SET stock = stock - ? WHERE id = ?";
                preparedStatement = conn.prepareStatement(updateQuery);
                preparedStatement.setInt(1, order.getNr());
                preparedStatement.setInt(2, order.getIdProduct());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.severe("ERROR executing SQL query: " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(preparedStatement);
            ConnectionFactory.close(conn);
        }
    }
}
