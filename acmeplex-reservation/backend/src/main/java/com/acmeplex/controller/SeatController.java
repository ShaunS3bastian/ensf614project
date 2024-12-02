package com.acmeplex.controller;

import com.acmeplex.model.Seat;
import com.acmeplex.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/showtime/{showtimeId}")
    public ResponseEntity<List<Seat>> getSeatsByShowtime(@PathVariable int showtimeId) {
        return ResponseEntity.ok(seatService.getSeatsByShowtime(showtimeId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Seat> updateSeatStatus(@PathVariable int id, @RequestBody Seat seat) {
        return ResponseEntity.ok(seatService.updateSeatStatus(id, seat));
    }
}
