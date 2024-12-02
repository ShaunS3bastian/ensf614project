package com.acmeplex.repository;

import com.acmeplex.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {
    /**
     * Find a registered user by email.
     *
     * @param email The email of the registered user.
     * @return RegisteredUser object if found, otherwise null.
     */
    RegisteredUser findByEmail(String email);
}
