package com.acmeplex.controller;

import com.acmeplex.model.Showtime;
import com.acmeplex.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping
    public ResponseEntity<List<Showtime>> getAllShowtimes() {
        return ResponseEntity.ok(showtimeService.getAllShowtimes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable int id) {
        return ResponseEntity.ok(showtimeService.getShowtimeById(id));
    }

    @GetMapping("/theatre/{theatreId}")
    public ResponseEntity<List<Showtime>> getShowtimesByTheatre(@PathVariable int theatreId) {
        return ResponseEntity.ok(showtimeService.getShowtimesByTheatre(theatreId));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Showtime>> getShowtimesByMovie(@PathVariable int movieId) {
        return ResponseEntity.ok(showtimeService.getShowtimesByMovie(movieId));
    }
}
