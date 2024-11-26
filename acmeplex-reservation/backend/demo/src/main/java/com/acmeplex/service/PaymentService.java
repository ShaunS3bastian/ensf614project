package com.acmeplex.service;

import com.acmeplex.model.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    // Process payment using Stripe
    public boolean processPayment(PaymentRequest paymentRequest) {
        try {
            // Set the Stripe secret key
            Stripe.apiKey = "your-stripe-secret-key"; // Replace with your actual Stripe secret key

            // Prepare payment parameters
            Map<String, Object> params = new HashMap<>();
            params.put("amount", paymentRequest.getAmount()); // Amount in cents
            params.put("currency", "usd"); // Currency code
            params.put("source", paymentRequest.getPaymentToken()); // Stripe payment token
            params.put("description", "Movie Ticket Payment");

            // Create the charge
            Charge charge = Charge.create(params);

            // Log successful payment
            System.out.println("Payment successful: " + charge.getId());
            return true;

        } catch (Exception e) {
            // Log payment failure
            System.err.println("Payment failed: " + e.getMessage());
            return false;
        }
    }

    // Process refunds
    public boolean processRefund(double amount, String transactionId) {
        try {
            // Placeholder for refund logic
            // Example: Stripe Refund API integration (if needed)
            System.out.println("Processing refund of $" + amount + " for transaction: " + transactionId);

            // Mock success for now
            return true;

        } catch (Exception e) {
            // Log refund failure
            System.err.println("Refund failed: " + e.getMessage());
            return false;
        }
    }
}
