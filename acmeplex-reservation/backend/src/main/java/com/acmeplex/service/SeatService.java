package com.acmeplex.service;

import com.acmeplex.model.Seat;
import com.acmeplex.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    /**
     * Fetch all seats.
     *
     * @return List of all seats
     */
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    /**
     * Fetch a seat by its ID.
     *
     * @param seatID Seat ID
     * @return Seat object or null if not found
     */
    public Seat getSeatById(int seatID) {
        return seatRepository.findById(seatID).orElse(null);
    }

    /**
     * Save or update a seat.
     *
     * @param seat Seat object to save
     * @return Saved Seat object
     */
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    /**
     * Delete a seat by its ID.
     *
     * @param seatID Seat ID
     */
    public void deleteSeat(int seatID) {
        seatRepository.deleteById(seatID);
    }

    /**
     * Fetch all seats by a specific showtime ID.
     *
     * @param showtimeID Showtime ID
     * @return List of seats associated with the given showtime
     */
    public List<Seat> getSeatsByShowtime(int showtimeID) {
        return seatRepository.findAll()
                .stream()
                .filter(seat -> seat.getShowtimes()
                        .stream()
                        .anyMatch(showtime -> showtime.getShowtimeID() == showtimeID))
                .collect(Collectors.toList());
    }

    /**
     * Update the status of a specific seat by its ID.
     *
     * @param seatID Seat ID
     * @param updatedSeat Updated Seat object with new status
     * @return Updated Seat object or null if not found
     */
    public Seat updateSeatStatus(int seatID, Seat updatedSeat) {
        Seat seat = seatRepository.findById(seatID).orElse(null);
        if (seat == null) {
            return null; // Seat not found
        }

        // Update the seat's attributes
        seat.setReserved(updatedSeat.isReserved());
        return seatRepository.save(seat);
    }
}
