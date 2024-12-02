package com.acmeplex.repository;

import com.acmeplex.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Seat findBySeatNumber(String seatNumber); // Find a seat by seat number
}
