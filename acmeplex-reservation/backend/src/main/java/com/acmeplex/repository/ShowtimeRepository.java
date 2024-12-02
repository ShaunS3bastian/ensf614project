package com.acmeplex.repository;

import com.acmeplex.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
    List<Showtime> findByMovie_Title(String movieTitle); // Find showtimes by movie title
    List<Showtime> findByTheatre_Name(String theatreName); // Find showtimes by theatre name
}
