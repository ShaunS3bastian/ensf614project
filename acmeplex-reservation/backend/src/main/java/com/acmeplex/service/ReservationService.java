package com.acmeplex.service;

import com.acmeplex.model.Reservation;
import com.acmeplex.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Fetch all reservations
     * 
     * @return List of all reservations
     */
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     * Fetch a reservation by ID
     * 
     * @param reservationID Reservation ID
     * @return Reservation object or null if not found
     */
    public Reservation getReservationById(int reservationID) {
        return reservationRepository.findById(reservationID).orElse(null);
    }

    /**
     * Save or update a reservation
     * 
     * @param reservation Reservation object to save
     * @return Saved Reservation object
     */
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * Delete a reservation by ID
     * 
     * @param reservationID Reservation ID
     */
    public void deleteReservation(int reservationID) {
        reservationRepository.deleteById(reservationID);
    }

    /**
     * Create a new reservation
     * 
     * @param reservation Reservation details to create
     * @return Created Reservation object
     */
    public Reservation createReservation(Reservation reservation) {
        if (reservation == null || reservation.getMovieTitle() == null || reservation.getTheatreName() == null) {
            throw new IllegalArgumentException("Invalid reservation details.");
        }

        // Add any additional validation or default values
        reservation.setShowtimeDate(
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        );

        return reservationRepository.save(reservation);
    }

    /**
     * Cancel a reservation
     * 
     * @param reservationID Reservation ID to cancel
     * @return True if successful, false otherwise
     */
    public boolean cancelReservation(int reservationID) {
        Reservation reservation = reservationRepository.findById(reservationID).orElse(null);

        if (reservation == null) {
            return false; // Reservation not found
        }

        // Check if the cancellation is within the allowed time frame (72 hours prior to showtime)
        LocalDateTime showtimeDate = LocalDateTime.parse(
            reservation.getShowtimeDate(),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        );
        if (LocalDateTime.now().isAfter(showtimeDate.minusHours(72))) {
            throw new IllegalStateException("Cannot cancel reservation within 72 hours of showtime.");
        }

        // Remove the reservation
        reservationRepository.deleteById(reservationID);
        return true;
    }
}
