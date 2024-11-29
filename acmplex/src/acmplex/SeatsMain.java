package acmplex;
import java.sql.*;
import java.util.Scanner;


public class SeatsMain {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            SeatsCRUD seatsCRUD = new SeatsCRUD(connection);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Create Seat");
                System.out.println("2. View Seat");
                System.out.println("3. Update Seat");
                System.out.println("4. Delete Seat");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1: // CREATE
                        System.out.print("Enter showtime ID: ");
                        int showtimeid = scanner.nextInt();
                        scanner.nextLine();  // Consume the newline character

                        System.out.print("Enter seat number (e.g., A1, B2): ");
                        String seatNumber = scanner.nextLine();

                        System.out.print("Is the seat reserved? (true/false): ");
                        boolean isReserved = scanner.nextBoolean();

                        System.out.print("Enter the user ID who reserved the seat (0 if not reserved): ");
                        int reservedBy = scanner.nextInt();

                        Seats newSeat = new Seats(0, showtimeid, seatNumber, isReserved, reservedBy);
                        seatsCRUD.createSeat(newSeat);
                        break;

                    case 2: // SELECT
                        System.out.print("Enter seat ID to view: ");
                        int seatIDToView = scanner.nextInt();
                        Seats seat = seatsCRUD.getSeatById(seatIDToView);
                        if (seat != null) {
                            System.out.println("Seat Details: " + seat);
                        }
                        break;

                    case 3: // UPDATE
                        System.out.print("Enter seat ID to update: ");
                        int seatIDToUpdate = scanner.nextInt();
                        scanner.nextLine();  // Consume the newline character

                        // Fetch the seat first
                        Seats seatToUpdate = seatsCRUD.getSeatById(seatIDToUpdate);
                        if (seatToUpdate != null) {
                            System.out.print("Enter new seat number: ");
                            String newSeatNumber = scanner.nextLine();

                            System.out.print("Is the seat reserved? (true/false): ");
                            boolean newIsReserved = scanner.nextBoolean();

                            System.out.print("Enter the user ID who reserved the seat (0 if not reserved): ");
                            int newReservedBy = scanner.nextInt();

                            // Update the seat object
                            seatToUpdate.setSeatNumber(newSeatNumber);
                            seatToUpdate.setReserved(newIsReserved);
                            seatToUpdate.setReservedBy(newReservedBy);

                            seatsCRUD.updateSeat(seatToUpdate);
                        }
                        break;

                    case 4: // DELETE
                        System.out.print("Enter seat ID to delete: ");
                        int seatIDToDelete = scanner.nextInt();
                        seatsCRUD.deleteSeat(seatIDToDelete);
                        break;

                    case 5: // Exit
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice, try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
