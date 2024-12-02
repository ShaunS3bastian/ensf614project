package com.acmeplex.repository;

import com.acmeplex.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUser_UserID(int userID); // Find reservations by user ID
    List<Reservation> findByTheatreName(String theatreName); // Find reservations by theatre name
}
