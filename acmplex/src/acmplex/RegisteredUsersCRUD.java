package acmplex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisteredUsersCRUD {
	 private Connection connection;

	    // Constructor to initialize the connection
	    public RegisteredUsersCRUD(Connection connection) {
	        this.connection = connection;
	    }

    // Create a new user
    public void createUser(RegisteredUsers user) throws SQLException {
        String sql = "INSERT INTO RegisteredUsers (userID, firstName, lastName, email, password, annualFeePaid, addressID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, user.userID);
            stmt.setString(2, user.firstName);
            stmt.setString(3, user.lastName);
            stmt.setString(4, user.email);
            stmt.setString(5, user.password);
            stmt.setBoolean(6, user.annualFeePaid);
            stmt.setInt(7, user.addressID);
            stmt.executeUpdate();
            System.out.println("User created successfully.");
        }
    }

    // Read user details by ID
    public RegisteredUsers getUserById(int userID) throws SQLException {
        String sql = "SELECT * FROM RegisteredUsers WHERE userID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                return new RegisteredUsers(
                    rs.getInt("userID"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getBoolean("annualFeePaid"),
                    rs.getInt("addressID")
                );
            } else {
                System.out.println("User not found.");
                return null;
            }
        }
    }

    // Update user details
    public void updateUser(RegisteredUsers user) throws SQLException {
        String sql = "UPDATE RegisteredUsers SET firstName = ?, lastName = ?, email = ?, password = ?, annualFeePaid = ?, addressID = ? WHERE userID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.firstName);
            stmt.setString(2, user.lastName);
            stmt.setString(3, user.email);
            stmt.setString(4, user.password);
            stmt.setBoolean(5, user.annualFeePaid);
            stmt.setInt(6, user.addressID);
            stmt.setInt(7, user.userID);
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
        String sql = "DELETE FROM RegisteredUsers WHERE userID = ?";
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
