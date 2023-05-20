package Connection;
import Presentation.ClientView;
import Presentation.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {

    public static void main(String[] args){
        View view = new View();
    }

    public static void main2() {

        // auto close connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/tema3pt", "root", "sergiu19A@")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
