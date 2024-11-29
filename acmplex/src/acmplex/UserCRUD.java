package acmplex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCRUD {
    private Connection connection;

    // Constructor to initialize the connection
    public UserCRUD(Connection connection) {
        this.connection = connection;
    }

    // Create a new user
    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (userID, isRegistered) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserID());
            stmt.setBoolean(2, user.isRegistered());
            stmt.executeUpdate();
            System.out.println("User created successfully.");
        }
    }

    // Read user details by ID
    public User getUserById(int userID) throws SQLException {
        String sql = "SELECT * FROM users WHERE userID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("userID"), rs.getBoolean("isRegistered"));
                } else {
                    System.out.println("User not found.");
                    return null;
                }
            }
        }
    }

    // Update user details
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET isRegistered = ? WHERE userID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, user.isRegistered());
            stmt.setInt(2, user.getUserID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User not found.");
            }
        }
    }

    // Delete user by ID
    public void deleteUser(int userID) throws SQLException {
        String sql = "DELETE FROM users WHERE userID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User not found.");
            }
        }
    }
}
