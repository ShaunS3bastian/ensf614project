package com.acmeplex.controller;

import com.acmeplex.model.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping("/process-payment")
    public ResponseEntity<?> processPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            // Set your Stripe secret key
            Stripe.apiKey = "your-stripe-secret-key";

            // Prepare payment details
            Map<String, Object> params = new HashMap<>();
            params.put("amount", paymentRequest.getAmount()); // Amount in cents
            params.put("currency", "usd");
            params.put("source", paymentRequest.getPaymentToken());
            params.put("description", "Movie Ticket Payment");

            // Process the payment
            Charge charge = Charge.create(params);

            // Return a successful response
            return ResponseEntity.ok(charge);
        } catch (Exception e) {
            // Return an error response if the payment fails
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
