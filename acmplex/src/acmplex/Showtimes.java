package acmplex;

import java.sql.Date;
import java.sql.Time;

public class Showtimes {
    private int showtimeID;
    private int theaterID;
    private int movieID;
    private Date showDate;
    private Time showtime;

    // Constructor
    public Showtimes(int showtimeID, int theaterID, int movieID, Date showDate, Time showtime) {
        this.showtimeID = showtimeID;
        this.theaterID = theaterID;
        this.movieID = movieID;
        this.showDate = showDate;
        this.showtime = showtime;
    }

    // Getters and Setters
    public int getShowtimeID() {
        return showtimeID;
    }

    public void setShowtimeID(int showtimeID) {
        this.showtimeID = showtimeID;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Time getShowtime() {
        return showtime;
    }

    public void setShowtime(Time showtime) {
        this.showtime = showtime;
    }

    @Override
    public String toString() {
        return "Showtime ID: " + showtimeID + ", Theater ID: " + theaterID + ", Movie ID: " + movieID +
               ", Show Date: " + showDate + ", Showtime: " + showtime;
    }
}
