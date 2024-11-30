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

    // SELECT relationship (via )
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Selection> selections;

    // Getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Selection> getSelections() {
        return selections;
    }

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }
}

