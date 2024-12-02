package com.acmeplex.repository;

import com.acmeplex.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByEmail(String email); // Find a payment by email
}
