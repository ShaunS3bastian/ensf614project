package acmplex;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class ShowtimesMain {
    public static void main(String[] args) {
        // Create a scanner to take input during runtime
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DatabaseConnection.getConnection()) {
            ShowtimesCRUD showtimesCRUD = new ShowtimesCRUD(connection);

            // Get user input for a new showtime
            System.out.print("Enter theater ID: ");
            int theaterId = scanner.nextInt();

            System.out.print("Enter movie ID: ");
            int movieId = scanner.nextInt();

            System.out.print("Enter show date (yyyy-mm-dd): ");
            String showDate = scanner.next();
            Date date = Date.valueOf(showDate);

            System.out.print("Enter show time (HH:mm:ss): ");
            String showTime = scanner.next();
            Time time = Time.valueOf(showTime);

            // CREATE a new showtime
            Showtimes newShowtime = new Showtimes(0, theaterId, movieId, date, time);
            showtimesCRUD.createShowtime(newShowtime);
            System.out.println("Showtime created successfully!");

            // READ all showtimes
            List<Showtimes> showtimes = showtimesCRUD.getAllShowtimes();
            System.out.println("All Showtimes:");
            for (Showtimes showtime : showtimes) {
                System.out.println(showtime);
            }

            // UPDATE a showtime
            System.out.print("\nEnter ID of the showtime you want to update: ");
            int showtimeIdToUpdate = scanner.nextInt();

            System.out.print("Enter new theater ID: ");
            int newTheaterId = scanner.nextInt();

            System.out.print("Enter new movie ID: ");
            int newMovieId = scanner.nextInt();

            System.out.print("Enter new show date (yyyy-mm-dd): ");
            String newShowDate = scanner.next();
            Date newDate = Date.valueOf(newShowDate);

            System.out.print("Enter new show time (HH:mm:ss): ");
            String newShowTime = scanner.next();
            Time newTime = Time.valueOf(newShowTime);

            Showtimes updatedShowtime = new Showtimes(showtimeIdToUpdate, newTheaterId, newMovieId, newDate, newTime);
            showtimesCRUD.updateShowtime(updatedShowtime);
            System.out.println("Showtime updated successfully!");

            // DELETE a showtime
            System.out.print("\nEnter ID of the showtime you want to delete: ");
            int showtimeIdToDelete = scanner.nextInt();
            showtimesCRUD.deleteShowtime(showtimeIdToDelete);
            System.out.println("Showtime deleted successfully!");

            // Get all showtimes after update and delete
            showtimes = showtimesCRUD.getAllShowtimes();
            System.out.println("Updated Showtimes:");
            for (Showtimes showtime : showtimes) {
                System.out.println(showtime);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}
