package com.acmeplex.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    private boolean isRegistered;

    // RECEIVES: 1 user can receive multiple tickets
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    // MAKES: 1 user can make many reservations
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // RECEIVES: 1 user can receive multiple credits
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Credit> credits;

    // PAY relationship (via PaymentDetail)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PaymentDetail> paymentDetails;

    // SELECT relationship (via Selection)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Selection> selections;

    // Constructors
    public User() {}

    public User(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    // Getters
    public int getUserID() {
        return userID;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public List<PaymentDetail> getPaymentDetails() {
        return paymentDetails;
    }

    public List<Selection> getSelections() {
        return selections;
    }

    // Setters
    
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }
}

