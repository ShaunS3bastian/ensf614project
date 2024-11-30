package com.acmeplex.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    // RECEIVES: 1 user can receive multiple tickets
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    // MAKES: 1 user can make many reservations
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
    
    // PAY relationship (via PaymentDetail)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PaymentDetail> paymentDetails;

    
}
