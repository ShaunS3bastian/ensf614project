package com.acmeplex.repository;

import com.acmeplex.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByEmail(String email); // Find tickets by user email
    List<Ticket> findByReservation_ReservationID(int reservationID); // Find tickets by reservation ID
}
