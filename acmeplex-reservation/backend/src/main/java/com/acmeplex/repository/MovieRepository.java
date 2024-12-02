package com.acmeplex.repository;

import com.acmeplex.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByStatus(String status); // Find movies by status (e.g., early, current)
    List<Movie> findByGenre(String genre);  // Find movies by genre
}
