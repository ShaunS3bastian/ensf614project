package com.acmeplex.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Selection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int selectionID;

    // Relationship with User
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    // Relationship with Movie
    @ManyToOne
    @JoinColumn(name = "movieID", nullable = false)
    private Movie movie;

    // Relationship with Theatre
    @ManyToOne
    @JoinColumn(name = "theatreID", nullable = false)
    private Theatre theatre;

    // Relationship with Showtime
    @ManyToOne
    @JoinColumn(name = "showtimeID", nullable = false)
    private Showtime showtime;

    // Relationship with Seats
    @ManyToMany
    @JoinTable(
        name = "selection_seats",
        joinColumns = @JoinColumn(name = "selectionID"),
        inverseJoinColumns = @JoinColumn(name = "seatID")
    )
    private List<Seat> seats;

    // Constructor

    public Selection() {}

    // Getters
    public int getSelectionID() {
        return selectionID;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    // Setters
    public void setSelectionID(int selectionID) {
        this.selectionID = selectionID;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
