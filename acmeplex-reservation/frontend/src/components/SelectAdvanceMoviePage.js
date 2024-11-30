import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "./SelectAdvanceMoviePage.css";

function SelectAdvanceMoviePage() {
  const location = useLocation();
  const navigate = useNavigate();
  const { state } = location;

  const title = state?.title || "Unknown Title";
  const poster = state?.poster || "";
  const genre = state?.genres[0] || "Genre";
  const duration = state?.duration || "N/A";
  const synopsis = state?.synopsis || "No synopsis available.";

  const handleBookAdvanceTickets = () => {
    navigate("/select-theatre", {
      state: { title },
    });
  };

  return (
    <div className="movie-page-container">
      <button className="back-button" onClick={() => navigate(-1)}>
        &#8592; Back
      </button>
      <div className="movie-details">
        <h1 className="movie-title">{title}</h1>
        <p className="movie-genre">{genre}</p>
        <p className="movie-duration">{duration}</p>
        <p className="movie-synopsis">{synopsis}</p>
        <button className="book-button" onClick={handleBookAdvanceTickets}>
          Book Advance Ticket
        </button>
      </div>
      <div className="movie-poster">
        <img src={poster} alt={title} />
      </div>
    </div>
  );
}

export default SelectAdvanceMoviePage;
