package com.acmeplex.repository;

import com.acmeplex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByIsRegistered(boolean isRegistered); // Find users by registration status
}
