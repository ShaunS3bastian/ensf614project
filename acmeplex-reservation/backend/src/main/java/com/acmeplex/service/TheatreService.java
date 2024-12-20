package com.acmeplex.service;

import com.acmeplex.model.Movie;
import com.acmeplex.model.Theatre;
import com.acmeplex.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    /**
     * Fetch all theatres.
     *
     * @return List of all theatres
     */
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    /**
     * Fetch a specific theatre by its ID.
     *
     * @param theatreID Theatre ID
     * @return Theatre object or null if not found
     */
    public Theatre getTheatreById(int theatreID) {
        return theatreRepository.findById(theatreID).orElse(null);
    }

    /**
     * Save or update a theatre.
     *
     * @param theatre Theatre object to save
     * @return Saved Theatre object
     */
    public Theatre saveTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    /**
     * Delete a theatre by its ID.
     *
     * @param theatreID Theatre ID
     */
    public void deleteTheatre(int theatreID) {
        theatreRepository.deleteById(theatreID);
    }

    /**
     * Fetch movies available at a specific theatre.
     *
     * @param theatreID Theatre ID
     * @return List of movies hosted by the theatre
     */
    public List<Movie> getMoviesByTheatre(int theatreID) {
        Theatre theatre = getTheatreById(theatreID);
        return theatre != null ? theatre.getMovies() : null;
    }
}
