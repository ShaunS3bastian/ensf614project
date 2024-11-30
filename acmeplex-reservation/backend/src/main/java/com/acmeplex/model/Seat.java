package com.acmeplex.model;
import jakarta.persistence.*;

import java.util.List;
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

    // SELECTS relationship (via Selection)
    @ManyToMany(mappedBy = "seats")
    private List<Selection> selections;

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

    public List<Selection> getSelections() {
        return selections;
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

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }
}
