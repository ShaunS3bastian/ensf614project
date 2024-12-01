package com.acmeplex.model;
import jakarta.persistence.*;

@Entity
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentDetailID;

    // Relationship with User
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    // Relationship with Reservation
    @OneToOne
    @JoinColumn(name = "reservationID", nullable = false)
    private Reservation reservation;

    // Relationship with Payment
    @OneToOne
    @JoinColumn(name = "paymentID", nullable = false)
    private Payment payment;

    // Constructor
    public PaymentDetail() {}    

    // Getters and Setters
    public int getPaymentDetailID() {
        return paymentDetailID;
    }

    public void setPaymentDetailID(int paymentDetailID) {
        this.paymentDetailID = paymentDetailID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
