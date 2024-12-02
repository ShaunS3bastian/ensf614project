package com.acmeplex.service;

import com.acmeplex.model.Seat;
import com.acmeplex.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAvailableSeats(Long showtimeId) {
        return seatRepository.findByShowtimeId(showtimeId)
                .stream()
                .filter(seat -> !seat.isReserved())
                .toList();
    }

    public Seat reserveSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found."));
        if (seat.isReserved()) {
            throw new IllegalArgumentException("Seat is already reserved.");
        }
        seat.setReserved(true);
        return seatRepository.save(seat);
    }
}
