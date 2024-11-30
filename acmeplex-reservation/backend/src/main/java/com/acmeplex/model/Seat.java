package com.acmeplex.model;
import com.acmeplex.model.*;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatID;

    private String row;
    private String number;
    private String seatNumber;
    private boolean isReserved;

    // HAS: many seats have many showtimes
    @ManyToMany(mappedBy = "seats")
    private Set<Showtime> showtimes;

    // SELECTS:

    // Constructor

    public Seat() {}

    public Seat(String row, String number) {
        this.row = row;
        this.number = number;
        this.seatNumber = this.row + this.number;
        this.isReserved = false;
    }

    // Getters 

    public int getSeatID() {
        return seatID;
    }

    public String getRow() {
        return row;
    }

    public String getNumber() {
        return number;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public Set<Showtime> getShowtimes() {
        return showtimes;
    }

    // Setters

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setShowtimes(Set<Showtime> showtimes) {
        this.showtimes = showtimes;
    }
}
