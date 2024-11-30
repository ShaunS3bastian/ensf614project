import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./CreateAccount.css";

function CreateAccount() {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    address: "",
    email: "",
    password: "",
    annualFee: false,
  });
  const [showPaymentModal, setShowPaymentModal] = useState(false); // For showing the payment modal
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    if (name === "annualFee" && checked) {
      setShowPaymentModal(true); // Show payment modal if the checkbox is clicked
    }

    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handlePaymentClose = () => {
    setShowPaymentModal(false); // Close the modal
    setFormData({ ...formData, annualFee: false }); // Uncheck the checkbox
  };

  const handlePaymentSubmit = (e) => {
    e.preventDefault();
    // Simulate payment processing
    alert("Payment Successful!");
    setShowPaymentModal(false);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (
      !formData.firstName ||
      !formData.lastName ||
      !formData.address ||
      !formData.email ||
      !formData.password ||
      !formData.annualFee
    ) {
      setError("Please fill all required fields and agree to the annual fee.");
      return;
    }
    setError("");
    alert("Account created successfully!");
    navigate("/"); // Redirect to Login Page
  };

  return (
    <div className="create-account-container">
      <h1 className="create-account-title">Create Account</h1>
      <form className="create-account-form" onSubmit={handleSubmit}>
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          className="create-account-input"
          value={formData.firstName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          className="create-account-input"
          value={formData.lastName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="address"
          placeholder="Address"
          className="create-account-input"
          value={formData.address}
          onChange={handleChange}
          required
        />
        <input
          type="email"
          name="email"
          placeholder="Email"
          className="create-account-input"
          value={formData.email}
          onChange={handleChange}
          required
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          className="create-account-input"
          value={formData.password}
          onChange={handleChange}
          required
        />
        <div className="checkbox-container">
          <input
            type="checkbox"
            name="annualFee"
            className="create-account-checkbox"
            checked={formData.annualFee}
            onChange={handleChange}
            required
          />
          <label className="checkbox-label">Pay $20 Annual Fee *</label>
        </div>
        {error && <p className="error-text">{error}</p>}
        <button type="submit" className="create-account-button">
          Create Account
        </button>
      </form>

      {/* Payment Modal */}
      {showPaymentModal && (
        <div className="payment-modal">
          <div className="payment-modal-content">
            <h2>Enter Payment Details</h2>
            <form onSubmit={handlePaymentSubmit}>
              <input
                type="text"
                placeholder="Card Number"
                className="payment-input"
                required
              />
              <input
                type="text"
                placeholder="Cardholder Name"
                className="payment-input"
                required
              />
              <input
                type="text"
                placeholder="Expiry Date (MM/YY)"
                className="payment-input"
                required
              />
              <input
                type="text"
                placeholder="CVV"
                className="payment-input"
                required
              />
              <div className="payment-modal-buttons">
                <button type="submit" className="payment-submit-button">
                  Pay
                </button>
                <button
                  type="button"
                  className="payment-cancel-button"
                  onClick={handlePaymentClose}
                >
                  Cancel
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}

export default CreateAccount;
