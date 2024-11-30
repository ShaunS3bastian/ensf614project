package com.acmeplex.model;
import com.acmeplex.model.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreID;

    private String name;
    
    @Embedded
    private Address location;

    // SELECTS relationship (via Selection)
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Selection> selections;

    // HOSTS: many theatres host many movies
    @ManyToMany(mappedBy = "theatreList")
    private List<Movie> movies;

    // SCHEDULES: 1 theatre schedules many showtimes
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Showtime> showtimes = new HashSet<>();

    // Constructors

    public Theatre() {}

    public Theatre(String name, Address location) {
        this.name = name;
        this.location = location;
    }

    // Getters

    public int getTheatreID() {
        return theatreID;
    }

    public String getName() {
        return name;
    }

    public Address getLocation() {
        return location;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Set<Showtime> getShowtimes() {
        return showtimes;
    }

    public List<Selection> getSelections() {
        return selections;
    }

    // Setters

    public void setTheatreID(int theatreID) {
        this.theatreID = theatreID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void setShowtimes(Set<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }
}
