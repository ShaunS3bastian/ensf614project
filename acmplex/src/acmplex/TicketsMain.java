package acmplex;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Scanner;

public class TicketsMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketCRUD ticketCRUD = new TicketCRUD();
        
        // Menu loop
        while (true) {
            System.out.println("\n--- Ticket CRUD Operations ---");
            System.out.println("1. Create Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Display All Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:  // Create Ticket
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Showtime ID: ");
                    int showtimeId = scanner.nextInt();
                    System.out.print("Enter Seat ID: ");
                    int seatId = scanner.nextInt();
                    System.out.print("Enter Ticket Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Purchase Date (yyyy-mm-ddThh:mm:ss): ");
                    String purchaseDateStr = scanner.nextLine();
                    LocalDateTime purchaseDate = LocalDateTime.parse(purchaseDateStr);
                    ticketCRUD.createTicket(ticketId, userId, showtimeId, seatId, 
                                             purchaseDate, price, false, null, 0.0, null);
                    break;
                case 2:  // View Ticket
                    System.out.print("Enter Ticket ID to view: ");
                    int viewTicketId = scanner.nextInt();
                    Tickets ticket = ticketCRUD.getTicketById(viewTicketId);
                    if (ticket != null) {
                        System.out.println("Ticket Details: " + ticket);
                    } else {
                        System.out.println("Ticket not found.");
                    }
                    break;
                case 3:  // Update Ticket
                    System.out.print("Enter Ticket ID to update: ");
                    int updateTicketId = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Is it cancelled? (true/false): ");
                    boolean newIsCancelled = scanner.nextBoolean();
                    System.out.print("Enter Cancellation Date (yyyy-mm-ddThh:mm:ss) or 'null' if not cancelled: ");
                    scanner.nextLine();  // Consume newline
                    String cancelDateStr = scanner.nextLine();
                    LocalDateTime newCancelDate = cancelDateStr.equals("null") ? null : LocalDateTime.parse(cancelDateStr);
                    System.out.print("Enter Credit Issued: ");
                    double newCreditIssued = scanner.nextDouble();
                    System.out.print("Enter Expiration Date (yyyy-mm-dd): ");
                    String expirationDateStr = scanner.next();
                    LocalDate newExpirationDate = LocalDate.parse(expirationDateStr);
                    if (ticketCRUD.updateTicket(updateTicketId, newPrice, newIsCancelled, 
                                                newCancelDate, newCreditIssued, newExpirationDate)) {
                        System.out.println("Ticket updated successfully.");
                    } else {
                        System.out.println("Ticket not found.");
                    }
                    break;
                case 4:  // Delete Ticket
                    System.out.print("Enter Ticket ID to delete: ");
                    int deleteTicketId = scanner.nextInt();
                    if (ticketCRUD.deleteTicket(deleteTicketId)) {
                        System.out.println("Ticket deleted successfully.");
                    } else {
                        System.out.println("Ticket not found.");
                    }
                    break;
                case 5:  // Display All Tickets
                    ticketCRUD.displayAllTickets();
                    break;
                case 6:  // Exit
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
