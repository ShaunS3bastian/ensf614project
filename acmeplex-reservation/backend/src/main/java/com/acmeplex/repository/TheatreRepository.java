package com.acmeplex.repository;

import com.acmeplex.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    Theatre findByName(String name); // Find a theatre by name
}
