import React from "react";
import { useNavigate, useLocation } from "react-router-dom";
import "./CardDetails.css";

function CardDetails() {
  const navigate = useNavigate();
  const location = useLocation();
  const { state } = location || {};
  const { movie, theatre, showtime, seats, totalPrice } = state || {};

  const handlePayment = () => {
    // After successful payment, navigate to ConfirmPaymentPage
    navigate("/confirm-payment", {
      state: {
        movie,
        theatre,
        showtime,
        seats,
        totalPrice,
      },
    });
  };

  return (
    <div className="card-details-container">
      <button className="back-button" onClick={() => navigate(-1)}>
        &#8592; Back
      </button>
      <h1 className="card-details-title">Card Details</h1>
      <form className="card-details-form">
        <input type="text" placeholder="Card Number" required />
        <input type="text" placeholder="Name on the Card" required />
        <div className="expiry-security">
          <input type="text" placeholder="Expiry Date (MM/YY)" required />
          <input type="text" placeholder="Security Code" required />
        </div>
        <input type="email" placeholder="Email" required />
        <button type="button" className="pay-button" onClick={handlePayment}>
          Pay ${totalPrice.toFixed(2)}
        </button>
      </form>
    </div>
  );
}

export default CardDetails;
