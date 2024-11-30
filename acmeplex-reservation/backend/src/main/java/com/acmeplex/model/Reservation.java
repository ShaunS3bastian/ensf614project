package com.acmeplex.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationID;

    private String movieTitle;
    private String theatreName;
    private String showtimeDate;
    private int numberOfTickets;
    private String[] seatNumbers;
    private double totalTicketPrice;
    private double redeemedCredit;
    private double tax;
    private double totalPrice;

    // MANAGES: 1 reservation can manage multiple tickets
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    // MAKES: Many reservations can be made by 1 user
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    // PAY relationship (via PaymentDetail)
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;

    // Constructors

    public Reservation() {}
    
    public Reservation(String movieTitle, String theatreName, String showtimeDate, int numberOfTickets,
                       String[] seatNumbers, double totalTicketPrice, double redeemedCredit, double tax, double totalPrice) {
        this.movieTitle = movieTitle;
        this.theatreName = theatreName;
        this.showtimeDate = showtimeDate;
        this.numberOfTickets = numberOfTickets;
        this.seatNumbers = seatNumbers;
        this.totalTicketPrice = totalTicketPrice;
        this.redeemedCredit = redeemedCredit;
        this.tax = tax;
        this.totalPrice = totalPrice;
    }

    // Getters

    public int getReservationID() {
        return reservationID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public String getShowtimeDate() {
        return showtimeDate;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public String[] getSeatNumbers() {
        return seatNumbers;
    }

    public double getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public double getRedeemedCredit() {
        return redeemedCredit;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public User getUser() {
        return user;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    // Setters

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public void setShowtimeDate(String showtimeDate) {
        this.showtimeDate = showtimeDate;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void setSeatNumbers(String[] seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public void setTotalTicketPrice(double totalTicketPrice) {
        this.totalTicketPrice = totalTicketPrice;
    }

    public void setRedeemedCredit(double redeemedCredit) {
        this.redeemedCredit = redeemedCredit;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }
}
