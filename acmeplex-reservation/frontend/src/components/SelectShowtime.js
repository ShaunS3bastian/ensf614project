import React, { useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "./SelectShowtime.css";

function SelectShowtime() {
  const location = useLocation();
  const navigate = useNavigate();

  // Movie and Theatre details passed via state
  const { state } = location;
  const movieTitle = state?.title || "Unknown Movie";
  const theatreName = state?.theatreName || "Unknown Theatre";

  // Schedule data
  const schedule = [
    {
      date: "2024-12-03",
      times: [
        { id: 1, time: "2:30 PM - 4:25 PM", format: "Cinema 1D", seatsAvailable: 25 },
        { id: 2, time: "2:50 PM - 4:45 PM", format: "Cinema 2D", seatsAvailable: 16 },
        { id: 3, time: "6:25 PM - 8:30 PM", format: "Cinema 2D", seatsAvailable: 12 },
      ],
    },
    {
      date: "2024-12-04",
      times: [
        { id: 4, time: "2:30 PM - 4:25 PM", format: "Cinema 1D", seatsAvailable: 20 },
        { id: 5, time: "2:50 PM - 4:45 PM", format: "Cinema 2D", seatsAvailable: 18 },
        { id: 6, time: "6:25 PM - 8:30 PM", format: "Cinema 2D", seatsAvailable: 10 },
      ],
    },
    {
      date: "2024-12-05",
      times: [
        { id: 7, time: "2:30 PM - 4:25 PM", format: "Cinema 1D", seatsAvailable: 22 },
        { id: 8, time: "2:50 PM - 4:45 PM", format: "Cinema 2D", seatsAvailable: 14 },
        { id: 9, time: "6:25 PM - 8:30 PM", format: "Cinema 2D", seatsAvailable: 8 },
      ],
    },
  ];

  const [selectedShowtime, setSelectedShowtime] = useState(null);
  const [selectedDate, setSelectedDate] = useState(null); // Allow null for showing all dates initially

  // Filter showtimes based on selected date or show all
  const filteredSchedule = selectedDate
    ? schedule.filter(
        (day) =>
          new Date(day.date).toDateString() ===
          new Date(selectedDate).toDateString()
      )
    : schedule; // Show all dates if no specific date is selected

  const handleSelectSeat = () => {
    if (selectedShowtime) {
      navigate("/select-seat", {
        state: {
          title: movieTitle,
          theatreName,
          showtime: selectedShowtime,
        },
      });
    } else {
      alert("Please select a showtime first!");
    }
  };

  return (
    <div className="select-showtime-container">
      <button className="back-button" onClick={() => navigate(-1)}>
        &#8592; Back
      </button>
      <h1 className="page-title">Schedule</h1>
      <h2 className="theatre-title">{theatreName}</h2>

      {/* Date Picker */}
      <div className="date-picker-container">
        <DatePicker
          selected={selectedDate}
          onChange={(date) => setSelectedDate(date)}
          placeholderText="Select Date"
          dateFormat="dd/MM/yyyy"
          className="date-picker-input"
        />
      </div>

      {/* Schedule List */}
      <div className="schedule-list">
        {filteredSchedule.length > 0 ? (
          filteredSchedule.map((day) => (
            <div key={day.date} className="schedule-day">
              <h3 className="schedule-date">
                Date: {new Date(day.date).toDateString()}
              </h3>
              <div className="time-slots">
                {day.times.map((slot) => (
                  <div
                    key={slot.id}
                    className={`time-slot ${
                      selectedShowtime?.id === slot.id ? "selected" : ""
                    }`}
                    onClick={() => setSelectedShowtime(slot)}
                  >
                    <p className="time">{slot.time}</p>
                    <p className="format">{slot.format}</p>
                    <p className="seats">Seats: {slot.seatsAvailable}</p>
                  </div>
                ))}
              </div>
            </div>
          ))
        ) : (
          <p>No showtimes available for the selected date.</p>
        )}
      </div>

      <button className="select-seat-button" onClick={handleSelectSeat}>
        Select Seat
      </button>
    </div>
  );
}

export default SelectShowtime;
