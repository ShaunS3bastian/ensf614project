package com.acmeplex.repository;

import com.acmeplex.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUserId(Long userId);
    List<Ticket> findByShowtimeId(Long showtimeId);
    List<Ticket> findByIsCancelled(boolean isCancelled);
}