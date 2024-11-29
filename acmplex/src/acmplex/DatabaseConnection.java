package acmplex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Method to get the connection to the database
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/MovieTicketBookingSystem"; // Replace with your actual DB URL
        String username = "root"; // Your DB username
        String password = "902210"; // Your DB password

        Connection connection = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            // Handle SQL exception
            System.out.println("Connection failed!");
            e.printStackTrace();
            throw e;  // Re-throw the exception after logging it
        }

        return connection;  // Return the established connection
    }
}
