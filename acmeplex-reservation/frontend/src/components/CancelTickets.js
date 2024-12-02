import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./CancelTickets.css";

function CancelTickets() {
  const navigate = useNavigate();
  const [ticketReference, setTicketReference] = useState("");
  const [email, setEmail] = useState("");

  const handleCancel = () => {
    if (!ticketReference || !email) {
      alert("Please provide both Ticket Reference Number and Email.");
      return;
    }

    // Simulate successful cancellation logic here
    navigate("/cancel-ticket-confirmation"); // Navigate to confirmation page
  };

  return (
    <div className="cancel-tickets-container">
      <h1 className="cancel-title">Cancel Tickets</h1>
      <div className="cancel-form">
        <input
          type="text"
          placeholder="Ticket Reference Number"
          value={ticketReference}
          onChange={(e) => setTicketReference(e.target.value)}
          className="cancel-input"
        />
        <input
          type="email"
          placeholder="Email ID"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          className="cancel-input"
        />
        <button className="cancel-button" onClick={handleCancel}>
          Cancel Ticket
        </button>
      </div>
    </div>
  );
}

export default CancelTickets;
