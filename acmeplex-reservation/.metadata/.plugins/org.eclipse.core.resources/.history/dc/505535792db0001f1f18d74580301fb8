package com.acmeplex.service;

import com.acmeplex.model.Showtime;
import com.acmeplex.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    // Find showtimes by movie ID
    public List<Showtime> findShowtimesByMovie(Long movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

    // Add a new showtime
    public Showtime addShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }
}
