package model;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AcmePlex";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed!");
        }
    }

    public ResultSet searchMovies(String title) throws SQLException {
        String query = "SELECT * FROM movies WHERE title LIKE ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, "%" + title + "%");
        return ps.executeQuery();
    }

    public ResultSet getAllMovies() throws SQLException {
        String query = "SELECT title FROM movies";
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public void bookTicket(String movie, String seat, String payment) throws SQLException {
        String query = "INSERT INTO reservations (movie, seat, payment) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, movie);
        ps.setString(2, seat);
        ps.setString(3, payment);
        ps.executeUpdate();
    }

    public void registerUser(String name, String email, String card) throws SQLException {
        String query = "INSERT INTO users (name, email, card) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, card);
        ps.executeUpdate();
    }

    public ResultSet getEarlyNews() throws SQLException {
        String query = "SELECT * FROM news";
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public boolean cancelTicket(int bookingId) throws SQLException {
        String query = "DELETE FROM reservations WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, bookingId);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    }
}
