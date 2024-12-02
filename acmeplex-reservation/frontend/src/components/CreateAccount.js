import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./CreateAccount.css";

function CreateAccount() {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    street: "",
    city: "",
    province: "",
    country: "",
    postalCode: "",
    cardNumber: "",
    cardName: "",
    expiryDate: "",
    securityCode: "",
    annualFee: false,
  });
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const requiredFields = [
      "firstName",
      "lastName",
      "email",
      "password",
      "street",
      "city",
      "province",
      "country",
      "postalCode",
      "cardNumber",
      "cardName",
      "expiryDate",
      "securityCode",
    ];

    for (let field of requiredFields) {
      if (!formData[field]) {
        setError("Please fill in all the required fields.");
        return;
      }
    }

    if (!formData.annualFee) {
      setError("You must agree to the $20 annual fee.");
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
        {/* Personal Details */}
        <div className="form-section">
          <div className="form-row">
            <input
              type="text"
              name="firstName"
              placeholder="First Name *"
              className="create-account-input"
              value={formData.firstName}
              onChange={handleChange}
              required
            />
            <input
              type="text"
              name="lastName"
              placeholder="Last Name *"
              className="create-account-input"
              value={formData.lastName}
              onChange={handleChange}
              required
            />
          </div>
          <input
            type="email"
            name="email"
            placeholder="Email *"
            className="create-account-input"
            value={formData.email}
            onChange={handleChange}
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Password *"
            className="create-account-input"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>

        {/* Address Details */}
        <div className="form-section">
          <h2 className="form-section-title">Address</h2>
          <input
            type="text"
            name="street"
            placeholder="Street *"
            className="create-account-input"
            value={formData.street}
            onChange={handleChange}
            required
          />
          <div className="form-row">
            <input
              type="text"
              name="city"
              placeholder="City *"
              className="create-account-input"
              value={formData.city}
              onChange={handleChange}
              required
            />
            <input
              type="text"
              name="province"
              placeholder="Province *"
              className="create-account-input"
              value={formData.province}
              onChange={handleChange}
              required
            />
          </div>
          <input
            type="text"
            name="country"
            placeholder="Country *"
            className="create-account-input"
            value={formData.country}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="postalCode"
            placeholder="Postal Code *"
            className="create-account-input"
            value={formData.postalCode}
            onChange={handleChange}
            required
          />
        </div>

        {/* Card Details */}
        <div className="form-section">
          <h2 className="form-section-title">Card Details</h2>
          <input
            type="text"
            name="cardNumber"
            placeholder="Card Number *"
            className="create-account-input"
            value={formData.cardNumber}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="cardName"
            placeholder="Name on the Card *"
            className="create-account-input"
            value={formData.cardName}
            onChange={handleChange}
            required
          />
          <div className="form-row">
            <input
              type="text"
              name="expiryDate"
              placeholder="Expiry Date (MM/YY) *"
              className="create-account-input"
              value={formData.expiryDate}
              onChange={handleChange}
              required
            />
            <input
              type="text"
              name="securityCode"
              placeholder="Security Code *"
              className="create-account-input"
              value={formData.securityCode}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        {/* Agreement Checkbox */}
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
    </div>
  );
}

export default CreateAccount;
