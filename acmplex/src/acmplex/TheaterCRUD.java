package acmplex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheaterCRUD {

    private Connection connection;

    // Constructor to initialize the connection
    public TheaterCRUD(Connection connection) {
        this.connection = connection;
    }

    // Create a new theater
    public void createTheater(Theater theater) throws SQLException {
        String sql = "INSERT INTO theater (Name, addressID) VALUES (?, ?)";  // Do not include theaterID, it's auto-increment

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, theater.getName());
            preparedStatement.setInt(2, theater.getAddressID());

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Retrieve the generated theaterID (auto-incremented)
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedID = generatedKeys.getInt(1);  // Retrieve the generated theaterID
                        theater.setTheaterID(generatedID);
                        System.out.println("Theater created with ID: " + generatedID);
                    }
                }
            } else {
                System.out.println("Theater creation failed.");
            }
        }
    }

    // Get all theaters
    public List<Theater> getAllTheaters() throws SQLException {
        List<Theater> theaters = new ArrayList<>();
        String sql = "SELECT theatreID, Name, addressID FROM theater";  // Correct column names

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int theaterID = resultSet.getInt("theatreID");
                String theaterName = resultSet.getString("Name");
                int addressID = resultSet.getInt("addressID");

                Theater theater = new Theater(theaterName, addressID);
                theater.setTheaterID(theaterID);  // Set the theaterID retrieved from the database
                theaters.add(theater);
            }
        }

        return theaters;
    }

    // Get a theater by its ID
    public Theater getTheaterById(int id) throws SQLException {
        String sql = "SELECT theaterID, Name, addressID FROM theater WHERE theaterID = ?";
        Theater theater = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int theaterID = resultSet.getInt("theatreID");
                String theaterName = resultSet.getString("Name");
                int addressID = resultSet.getInt("addressID");

                theater = new Theater(theaterName, addressID);
                theater.setTheaterID(theaterID);
            }
        }

        return theater;
    }

    // Update theater details
    public void updateTheater(Theater theater) throws SQLException {
        String sql = "UPDATE theater SET Name = ?, addressID = ? WHERE theatreID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, theater.getName());
            preparedStatement.setInt(2, theater.getAddressID());
            preparedStatement.setInt(3, theater.getTheaterID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Theater updated successfully!");
            } else {
                System.out.println("Theater update failed.");
            }
        }
    }

    // Delete a theater by its ID
    public void deleteTheater(int id) throws SQLException {
        String sql = "DELETE FROM theater WHERE theatreID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Theater deleted successfully!");
            } else {
                System.out.println("Theater deletion failed.");
            }
        }
    }
}
