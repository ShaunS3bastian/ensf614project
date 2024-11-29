package acmplex;
import java.sql.*;

public class SeatsCRUD {
    private Connection connection;

    public SeatsCRUD(Connection connection) {
        this.connection = connection;
    }

    // CREATE seat
    public void createSeat(Seats seat) throws SQLException {
        String query = "INSERT INTO Seats (showtimeid, seat_number, is_reserved, reservedby) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, seat.getShowtimeid());
            statement.setString(2, seat.getSeatNumber());
            statement.setBoolean(3, seat.isReserved());
            statement.setInt(4, seat.getReservedBy());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Seat created successfully!");
            } else {
                System.out.println("Error inserting seat.");
            }
        }
    }

    // SELECT seat by ID
    public Seats getSeatById(int seatID) throws SQLException {
        String query = "SELECT * FROM Seats WHERE seat_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, seatID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int showtimeid = resultSet.getInt("showtimeid");
                String seatNumber = resultSet.getString("seat_number");
                boolean isReserved = resultSet.getBoolean("is_reserved");
                int reservedBy = resultSet.getInt("reserved_by");

                return new Seats(seatID, showtimeid, seatNumber, isReserved, reservedBy);
            } else {
                System.out.println("No seat found with ID: " + seatID);
                return null;
            }
        }
    }

    // UPDATE seat by ID
    public void updateSeat(Seats seat) throws SQLException {
        String query = "UPDATE Seats SET showtimeid = ?, seat_number = ?, is_reserved = ?, reservedby = ? WHERE seat_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, seat.getShowtimeid());
            statement.setString(2, seat.getSeatNumber());
            statement.setBoolean(3, seat.isReserved());
            statement.setInt(4, seat.getReservedBy());
            statement.setInt(5, seat.getSeatID());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Seat updated successfully!");
            } else {
                System.out.println("Error updating seat.");
            }
        }
    }

    // DELETE seat by ID
    public void deleteSeat(int seatID) throws SQLException {
        String query = "DELETE FROM Seats WHERE seat_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, seatID);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Seat deleted successfully!");
            } else {
                System.out.println("Error deleting seat.");
            }
        }
    }
}
