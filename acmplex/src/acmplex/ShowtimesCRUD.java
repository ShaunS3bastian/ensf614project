package acmplex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowtimesCRUD {

    private Connection connection;

    // Constructor
    public ShowtimesCRUD(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void createShowtime(Showtimes showtime) throws SQLException {
        String query = "INSERT INTO Showtimes (theaterid, movieid, showdate, showtime) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, showtime.getTheaterID());
            statement.setInt(2, showtime.getMovieID());
            statement.setDate(3, showtime.getShowDate());
            statement.setTime(4, showtime.getShowtime());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    showtime.setShowtimeID(generatedKeys.getInt(1)); // Get auto-generated showtimeID
                    System.out.println("Showtime created with ID: " + showtime.getShowtimeID());
                }
            }
        }
    }

    // READ
    public List<Showtimes> getAllShowtimes() throws SQLException {
        List<Showtimes> showtimesList = new ArrayList<>();
        String query = "SELECT * FROM Showtimes";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Showtimes showtime = new Showtimes(
                        resultSet.getInt("showtimeid"),
                        resultSet.getInt("theaterid"),
                        resultSet.getInt("movieid"),
                        resultSet.getDate("showdate"),
                        resultSet.getTime("showtime")
                );
                showtimesList.add(showtime);
            }
        }
        return showtimesList;
    }

    // UPDATE
    public void updateShowtime(Showtimes showtime) throws SQLException {
        String query = "UPDATE Showtimes SET theaterid = ?, movieid = ?, showdate = ?, showtime = ? WHERE showtimeid = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, showtime.getTheaterID());
            statement.setInt(2, showtime.getMovieID());
            statement.setDate(3, showtime.getShowDate());
            statement.setTime(4, showtime.getShowtime());
            statement.setInt(5, showtime.getShowtimeID());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Showtime updated with ID: " + showtime.getShowtimeID());
            }
        }
    }

    // DELETE
    public void deleteShowtime(int showtimeID) throws SQLException {
        String query = "DELETE FROM Showtimes WHERE showtimeid = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, showtimeID);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Showtime deleted with ID: " + showtimeID);
            }
        }
    }
}
