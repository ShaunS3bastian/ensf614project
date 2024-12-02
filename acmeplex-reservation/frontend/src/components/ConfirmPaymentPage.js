import React from "react";
import { useNavigate } from "react-router-dom";
import "./ConfirmPaymentPage.css";

function ConfirmPaymentPage() {
  const navigate = useNavigate();

  const handleBackToHome = () => {
    navigate("/");
  };

  return (
    <div className="confirm-payment-container">
      <button className="back-button" onClick={handleBackToHome}>
        &#8592; Back to Home
      </button>
      <h1 className="confirmation-title">Ticket(s) Reserved Successfully</h1>
      <p className="confirmation-message">
        Your ticket(s) and receipt have been sent to your email.
      </p>
      <p className="thank-you-message">Thank you for choosing ACMEPLEX.</p>
    </div>
  );
}

export default ConfirmPaymentPage;
