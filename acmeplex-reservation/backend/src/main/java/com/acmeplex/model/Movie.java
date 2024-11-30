package com.acmeplex.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;

    private String status;              //early, current
    private String title;
    private String genre;
    private String duration;           // ex. 2h 13m
    private String description;

    // SELECTS relationship (via Selection)
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Selection> selections;

    // PLAY: 1 movie plays at many showtimes
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Showtime> showtimeList;

    // HOST : many movies are hosted by many theatres
    @ManyToMany
    @JoinTable(
        name = "movie_theatre",
        joinColumns = @JoinColumn(name = "movieID"),
        inverseJoinColumns = @JoinColumn(name = "theatreID")
    )
    private List<Theatre> theatreList;

    // Constructors

    // Getters

    public int getMovieID() {
        return movieID;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public List<Theatre> getTheatreList() {
        return theatreList;
    }

    public List<Showtime> getShowtimeList() {
        return showtimeList;
    }

    public List<Selection> getSelections() {
        return selections;
    }

    // Setters

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTheatreList(List<Theatre> theatreList) {
        this.theatreList = theatreList;
    }

    public void setShowtimeList(List<Showtime> showtimeList) {
        this.showtimeList = showtimeList;
    }

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }

}
