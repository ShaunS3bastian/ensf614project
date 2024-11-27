package com.acmeplex.repository;

import com.acmeplex.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Find movies by genre (case-insensitive)
    List<Movie> findByGenreIgnoreCase(String genre);

    // Find movies by title (case-insensitive, partial match)
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
