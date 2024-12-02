package com.acmeplex.controller;

import com.acmeplex.model.Theatre;
import com.acmeplex.model.Movie;
import com.acmeplex.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable int id) {
        return ResponseEntity.ok(theatreService.getTheatreById(id));
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<List<Movie>> getMoviesByTheatre(@PathVariable int id) {
        return ResponseEntity.ok(theatreService.getMoviesByTheatre(id));
    }
}
