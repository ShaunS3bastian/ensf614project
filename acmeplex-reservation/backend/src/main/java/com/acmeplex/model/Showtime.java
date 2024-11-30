package com.acmeplex.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showtimeID;

    private String dateTime;        // ex. Dec 3rd, 6:00 PM

    // PLAY: many showtimes play 1 movie
    @ManyToOne
    @JoinColumn(name = "movieID", nullable = false)
    private Movie movie;

    // SCHEDULES: many showtimes are scheduled for 1 theatre
    @ManyToOne
    @JoinColumn(name = "theatreID", nullable = false)
    private Theatre theatre;

    // HAS: many showtimes have many seats
    @ManyToMany
    @JoinTable(
        name = "showtime_seat",
        joinColumns = @JoinColumn(name = "showtimeID"),
        inverseJoinColumns = @JoinColumn(name = "seatID")
    )
    private Set<Seat> seats;

    // SELECTS relationship (via Selection)
    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private List<Selection> selections;

    // Constructors

    public Showtime() {}

    public Showtime(String dateTime, Movie movie, Theatre theatre, Set<Seat> seats) {
        this.dateTime = dateTime;
        this.movie = movie;
        this.theatre = theatre;
        this.seats = seats;
    }

    // Getters 
    public int getShowtimeID() {
        return showtimeID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }
    
    public Set<Seat> getSeats() {
        return seats;
    }
    
    public List<Selection> getSelections() {
        return selections;
    }

    // Setters

    public void setShowtimeID(int showtimeID) {
        this.showtimeID = showtimeID;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }
}
