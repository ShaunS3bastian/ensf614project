package acmplex;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class Tickets {
    private int ticketId;             // Unique identifier for the ticket
    private int userId;               // User who purchased the ticket
    private int showtimeId;           // Showtime ID for the ticket
    private int seatId;               // Seat ID for the ticket
    private LocalDateTime purchaseDate; // Date and time the ticket was purchased
    private double price;             // Ticket price
    private boolean isCancelled;      // Indicates if the ticket was canceled
    private LocalDateTime cancelDate; // Date and time the ticket was canceled
    private double creditIssued;      // Amount credited after cancellation
    private LocalDate expirationDate; // Expiry date of the credit

    // Constructor for creating a new ticket
    public Tickets(int ticketId, int userId, int showtimeId, int seatId, 
                   LocalDateTime purchaseDate, double price, boolean isCancelled, 
                   LocalDateTime cancelDate, double creditIssued, LocalDate expirationDate) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.seatId = seatId;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.isCancelled = isCancelled;
        this.cancelDate = cancelDate;
        this.creditIssued = creditIssued;
        this.expirationDate = expirationDate;
    }

    // Empty constructor for flexibility
    public Tickets() {}

    // Getters and setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public LocalDateTime getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDateTime cancelDate) {
        this.cancelDate = cancelDate;
    }

    public double getCreditIssued() {
        return creditIssued;
    }

    public void setCreditIssued(double creditIssued) {
        this.creditIssued = creditIssued;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", userId=" + userId +
                ", showtimeId=" + showtimeId +
                ", seatId=" + seatId +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", isCancelled=" + isCancelled +
                ", cancelDate=" + cancelDate +
                ", creditIssued=" + creditIssued +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
