package com.acmeplex.service;

import com.acmeplex.model.Movie;
import com.acmeplex.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Fetch all movies
     * @return List of Movie
     */
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * Fetch a movie by its ID
     * @param movieID Movie ID
     * @return Movie if found, otherwise null
     */
    public Movie getMovieById(int movieID) {
        return movieRepository.findById(movieID).orElse(null);
    }

    /**
     * Save or update a movie
     * @param movie Movie object to save
     * @return Saved Movie
     */
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Delete a movie by its ID
     * @param movieID Movie ID to delete
     */
    public void deleteMovie(int movieID) {
        movieRepository.deleteById(movieID);
    }

    /**
     * Fetch all "Coming Soon" movies
     * @return List of Movie with status "Coming Soon"
     */
    public List<Movie> getComingSoonMovies() {
        return movieRepository.findAll().stream()
                .filter(movie -> "Coming Soon".equalsIgnoreCase(movie.getStatus()))
                .collect(Collectors.toList());
    }

    /**
     * Fetch all "Now Showing" movies
     * @return List of Movie with status "Now Showing"
     */
    public List<Movie> getNowShowingMovies() {
        return movieRepository.findAll().stream()
                .filter(movie -> "Now Showing".equalsIgnoreCase(movie.getStatus()))
                .collect(Collectors.toList());
    }
}
