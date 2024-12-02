import React from "react";
import { useNavigate, useLocation } from "react-router-dom";
import "./PaymentPage.css";

function PaymentPage() {
  const navigate = useNavigate();
  const location = useLocation();

  const { state } = location || {};
  const movie = state?.movie || "Unknown Movie";
  const theatre = state?.theatre || "Unknown Theatre";
  const showtime = state?.showtime || "Unknown Showtime";
  const selectedSeats = state?.seats || [];
  const ticketPrice = 15.0;
  const tax = 1.5;
  const redeemedCredit = 0; // Default to 0 if no code is applied
  const totalPrice = ticketPrice * selectedSeats.length + tax - redeemedCredit;

  const handleConfirm = () => {
    if (selectedSeats.length === 0) {
      alert("No seats selected. Please return to seat selection.");
      return;
    }

    // Navigate to CardDetails page for payment input
    navigate("/card-details", {
      state: {
        movie,
        theatre,
        showtime,
        seats: selectedSeats,
        totalPrice,
      },
    });
  };

  return (
    <div className="payment-container">
      <button className="back-button" onClick={() => navigate(-1)}>
        &#8592; Back
      </button>
      <h1 className="payment-title">Purchase Tickets</h1>

      <div className="details-container">
        <div className="details-row">
          <span className="details-label">Movie</span>
          <span className="details-value">{movie}</span>
        </div>
        <div className="details-row">
          <span className="details-label">Theatre</span>
          <span className="details-value">{theatre}</span>
        </div>
        <div className="details-row">
          <span className="details-label">Showtime</span>
          <span className="details-value">{showtime}</span>
        </div>
        <div className="details-row">
          <span className="details-label">Number of Tickets</span>
          <span className="details-value">{selectedSeats.length}</span>
        </div>
        <div className="details-row">
          <span className="details-label">Seat Numbers</span>
          <span className="details-value">
            {selectedSeats.length > 0 ? selectedSeats.join(", ") : "None"}
          </span>
        </div>
        <div className="details-row">
          <span className="details-label">Ticket Price</span>
          <span className="details-value">
            ${(ticketPrice * selectedSeats.length).toFixed(2)}
          </span>
        </div>
        <div className="details-row">
          <span className="details-label">Redeemed Credit</span>
          <span className="details-value">-${redeemedCredit.toFixed(2)}</span>
        </div>
        <div className="details-row">
          <span className="details-label">Tax</span>
          <span className="details-value">${tax.toFixed(2)}</span>
        </div>
        <div className="details-row total">
          <span className="details-label">Total Price</span>
          <span className="details-value">${totalPrice.toFixed(2)}</span>
        </div>
      </div>

      <div className="redeem-container">
        <input
          type="text"
          placeholder="Redeem Code"
          className="redeem-input"
        />
      </div>

      <button className="confirm-button" onClick={handleConfirm}>
        Proceed to Payment
      </button>
    </div>
  );
}

export default PaymentPage;
