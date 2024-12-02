import React, { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import "./SelectSeat.css";

function SelectSeat() {
  const navigate = useNavigate();
  const location = useLocation();

  const { state } = location || {};
  const selectedSchedule = state?.schedule || {
    date: "Unknown Date",
    time: "Unknown Time",
    format: "Unknown Format",
  };
  const theatreName = state?.theatreName || "Unknown Theatre";

  const rows = 8;
  const columns = 8;
  const totalSeats = rows * columns;

  const [selectedSeats, setSelectedSeats] = useState([]);
  const [seats, setSeats] = useState([]);

  // Generate seats with randomized reserved status
  useEffect(() => {
    const generateSeats = () => {
      const reservedIndexes = new Set();
      while (reservedIndexes.size < Math.floor(totalSeats * 0.2)) {
        reservedIndexes.add(Math.floor(Math.random() * totalSeats));
      }

      return Array.from({ length: totalSeats }, (_, index) => ({
        id: index + 1,
        number: `${String.fromCharCode(65 + Math.floor(index / columns))}${(index % columns) + 1}`,
        status: reservedIndexes.has(index) ? "reserved" : "available",
      }));
    };

    setSeats(generateSeats());
  }, [totalSeats, columns]);

  const handleSeatClick = (seat) => {
    if (seat.status === "reserved") return;

    const updatedSeats = [...seats];
    const seatIndex = updatedSeats.findIndex((s) => s.id === seat.id);

    if (updatedSeats[seatIndex].status === "available") {
      updatedSeats[seatIndex].status = "selected";
      setSelectedSeats([...selectedSeats, seat.number]);
    } else if (updatedSeats[seatIndex].status === "selected") {
      updatedSeats[seatIndex].status = "available";
      setSelectedSeats(selectedSeats.filter((s) => s !== seat.number));
    }

    setSeats(updatedSeats);
  };

  const handleBuyNow = () => {
    if (selectedSeats.length === 0) {
      alert("Please select at least one seat before proceeding.");
      return;
    }

    navigate("/payment", {
      state: {
        schedule: selectedSchedule,
        theatreName,
        seats: selectedSeats,
      },
    });
  };

  return (
    <div className="select-seat-container">
      <div className="header">
        <button className="back-button" onClick={() => navigate(-1)}>
          &#8592; Back
        </button>
        <h1 className="schedule-title">Schedule</h1>
        <div className="schedule-info">
          <p><strong>Date:</strong> {selectedSchedule.date}</p>
          <p><strong>Time:</strong> {selectedSchedule.time}</p>
          <p><strong>Format:</strong> {selectedSchedule.format}</p>
        </div>
        <p className="theatre-name">{theatreName}</p>
      </div>

      <div className="seats-grid">
        {seats.map((seat) => (
          <div
            key={seat.id}
            className={`seat ${seat.status}`}
            onClick={() => handleSeatClick(seat)}
          >
            {seat.number}
          </div>
        ))}
      </div>

      <div className="seat-legend">
        <div className="legend-item">
          <div className="seat available"></div>
          <p>Available</p>
        </div>
        <div className="legend-item">
          <div className="seat reserved"></div>
          <p>Reserved</p>
        </div>
        <div className="legend-item">
          <div className="seat selected"></div>
          <p>Selected</p>
        </div>
      </div>

      <div className="footer">
        <p className="selected-seats">
          <strong>{selectedSeats.length}</strong> Seat(s) Selected:{" "}
          {selectedSeats.join(", ") || "None"}
        </p>
        <button className="buy-now-button" onClick={handleBuyNow}>
          Buy Now
        </button>
      </div>
    </div>
  );
}

export default SelectSeat;
