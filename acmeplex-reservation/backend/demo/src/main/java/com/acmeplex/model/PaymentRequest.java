package com.acmeplex.model;

public class PaymentRequest {
    private int amount; // Amount in cents (e.g., $10.00 = 1000)
    private String paymentToken; // Stripe payment token from the frontend

    // Getters and setters
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }
}
