package acmplex;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TicketCRUD {

    // List to simulate a database (In a real app, this would connect to an actual database)
    private List<Tickets> ticketsDatabase = new ArrayList<>();

    // Create: Add a new ticket
    public void createTicket(int ticketId, int userId, int showtimeId, int seatId, 
                             LocalDateTime purchaseDate, double price, boolean isCancelled, 
                             LocalDateTime cancelDate, double creditIssued, LocalDate expirationDate) {
        Tickets newTicket = new Tickets(ticketId, userId, showtimeId, seatId, 
                                        purchaseDate, price, isCancelled, cancelDate, creditIssued, expirationDate);
        ticketsDatabase.add(newTicket);
        System.out.println("Ticket created: " + newTicket);
    }

    // Read: Get ticket by ticketId
    public Tickets getTicketById(int ticketId) {
        for (Tickets ticket : ticketsDatabase) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }
        return null;  // Ticket not found
    }

    // Update: Update ticket details
    public boolean updateTicket(int ticketId, double newPrice, boolean newIsCancelled, 
                                 LocalDateTime newCancelDate, double newCreditIssued, LocalDate newExpirationDate) {
        Tickets ticket = getTicketById(ticketId);
        if (ticket != null) {
            ticket.setPrice(newPrice);
            ticket.setCancelled(newIsCancelled);
            ticket.setCancelDate(newCancelDate);
            ticket.setCreditIssued(newCreditIssued);
            ticket.setExpirationDate(newExpirationDate);
            System.out.println("Ticket updated: " + ticket);
            return true;
        }
        return false;  // Ticket not found
    }

    // Delete: Remove ticket by ticketId
    public boolean deleteTicket(int ticketId) {
        Tickets ticket = getTicketById(ticketId);
        if (ticket != null) {
            ticketsDatabase.remove(ticket);
            System.out.println("Ticket deleted: " + ticket);
            return true;
        }
        return false;  // Ticket not found
    }

    // Display all tickets
    public void displayAllTickets() {
        if (ticketsDatabase.isEmpty()) {
            System.out.println("No tickets available.");
        } else {
            for (Tickets ticket : ticketsDatabase) {
                System.out.println(ticket);
            }
        }
    }
}
