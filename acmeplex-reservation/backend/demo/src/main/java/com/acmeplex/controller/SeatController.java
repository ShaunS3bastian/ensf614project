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
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Long showtimeId) {
        return ResponseEntity.ok(seatService.getAvailableSeats(showtimeId));
    }

    @PostMapping("/reserve/{seatId}")
    public ResponseEntity<Seat> reserveSeat(@PathVariable Long seatId) {
        return ResponseEntity.ok(seatService.reserveSeat(seatId));
    }
}
