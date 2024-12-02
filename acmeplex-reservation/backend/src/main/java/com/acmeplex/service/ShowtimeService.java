package com.acmeplex.service;

import com.acmeplex.model.Showtime;
import com.acmeplex.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    /**
     * Fetch all showtimes.
     *
     * @return List of all showtimes
     */
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    /**
     * Fetch a specific showtime by its ID.
     *
     * @param showtimeID Showtime ID
     * @return Showtime object or null if not found
     */
    public Showtime getShowtimeById(int showtimeID) {
        return showtimeRepository.findById(showtimeID).orElse(null);
    }

    /**
     * Save or update a showtime.
     *
     * @param showtime Showtime object to save
     * @return Saved Showtime object
     */
    public Showtime saveShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    /**
     * Delete a showtime by its ID.
     *
     * @param showtimeID Showtime ID
     */
    public void deleteShowtime(int showtimeID) {
        showtimeRepository.deleteById(showtimeID);
    }

    /**
     * Fetch showtimes by a specific movie ID.
     *
     * @param movieID Movie ID
     * @return List of showtimes associated with the given movie
     */
    public List<Showtime> getShowtimesByMovie(int movieID) {
        return showtimeRepository.findAll()
                .stream()
                .filter(showtime -> showtime.getMovie().getMovieID() == movieID)
                .collect(Collectors.toList());
    }

    /**
     * Fetch showtimes by a specific theatre ID.
     *
     * @param theatreID Theatre ID
     * @return List of showtimes associated with the given theatre
     */
    public List<Showtime> getShowtimesByTheatre(int theatreID) {
        return showtimeRepository.findAll()
                .stream()
                .filter(showtime -> showtime.getTheatre().getTheatreID() == theatreID)
                .collect(Collectors.toList());
    }
}
