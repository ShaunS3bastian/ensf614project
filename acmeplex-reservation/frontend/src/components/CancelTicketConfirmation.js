import React from "react";
import { useNavigate } from "react-router-dom";
import "./CancelTicketConfirmation.css";

function CancelTicketConfirmation() {
  const navigate = useNavigate();

  const handleBackToHome = () => {
    navigate("/"); // Navigate back to the homepage
  };

  return (
    <div className="confirmation-container">
      <h1 className="confirmation-title">Ticket Successfully Cancelled</h1>
      <p className="confirmation-message">
        Your ticket has been cancelled. If you have any issues, please contact our support team.
      </p>
      <button className="back-button" onClick={handleBackToHome}>
        Back to Homepage
      </button>
    </div>
  );
}

export default CancelTicketConfirmation;
