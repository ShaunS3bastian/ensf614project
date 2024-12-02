package com.acmeplex.service;

import com.acmeplex.model.Payment;
import com.acmeplex.model.PaymentDetail;
import com.acmeplex.repository.PaymentRepository;
import com.acmeplex.repository.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;

    /**
     * Fetch all payments
     * @return List of payments
     */
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    /**
     * Fetch payment by ID
     * @param paymentID Payment ID
     * @return Payment object or null if not found
     */
    public Payment getPaymentById(int paymentID) {
        return paymentRepository.findById(paymentID).orElse(null);
    }

    /**
     * Save or update a payment
     * @param payment Payment object to save
     * @return Saved Payment object
     */
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    /**
     * Delete a payment by its ID
     * @param paymentID Payment ID
     */
    public void deletePayment(int paymentID) {
        paymentRepository.deleteById(paymentID);
    }

    /**
     * Process a payment
     * @param payment Payment object with details to process
     * @return Processed Payment object
     * @throws IllegalArgumentException if validation fails
     */
    public Payment processPayment(Payment payment) {
        if (payment == null || payment.getCardDetail() == null || payment.getEmail() == null) {
            throw new IllegalArgumentException("Invalid payment details.");
        }

        // Simulate payment processing logic (e.g., calling a third-party payment gateway)
        // Here, we assume the payment is always successful.

        Payment processedPayment = paymentRepository.save(payment);

        // Optionally, create a PaymentDetail entry if needed
        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setPayment(processedPayment);
        paymentDetailRepository.save(paymentDetail);

        return processedPayment;
    }
}
