package com.acmeplex.model;
import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;

    private String seatNumber;
    private String showtimeDate;
    private String theatreName;
    private String movieTitle;
    private String email;
    private double price;

    // GENERATES: One ticket generates 0..1 credit
    @OneToOne(mappedBy = "ticket")        
    private Credit credit;

    // MANAGES: Many tickets can be managed by 1 reservation
    @ManyToOne
    @JoinColumn(name = "reservationID", nullable = false)
    private Reservation reservation;

    // RECEIVES: Many tickets can be received by 1 User
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    // Constructors

    public Ticket() {}

    public Ticket(String seatNumber, String showtimeDate, String theatreName, String movieTitle, String email, double price) {
        this.seatNumber = seatNumber;
        this.showtimeDate = showtimeDate;
        this.theatreName = theatreName;
        this.movieTitle = movieTitle;
        this.email = email;
        this.price = price;
    }

    // Getters
    public int getTicketID() {
        return ticketID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getShowtimeDate() {
        return showtimeDate;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getEmail() {
        return email;
    }

    public double getPrice() {
        return price;
    }

    public Credit getCredit() {
        return credit;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public User getUser() {
        return user;
    }

    // Setters
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setShowtimeDate(String showtimeDate) {
        this.showtimeDate = showtimeDate;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

