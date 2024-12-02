import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "./SelectMovie.css";

function SelectMovie() {
  const location = useLocation();
  const navigate = useNavigate();
  const { state } = location;

  const title = state?.title || "Unknown Title";
  const poster = state?.poster || "/images/placeholder.png";
  const genre = state?.genres ? state.genres[0] : "Genre";
  const duration = state?.duration || "N/A";
  const synopsis = state?.synopsis || "No synopsis available.";

  const handleBookTickets = () => {
    navigate("/select-theatre", {
      state: { title },
    });
  };

  return (
    <div className="movie-page-container">
      <button className="back-button" onClick={() => navigate(-1)}>
        &#8592; Back
      </button>
      <div className="movie-content">
        {/* Movie Details */}
        <div className="movie-details">
          <div className="movie-info">
            <span className="movie-genre">{genre}</span>
            <span className="movie-duration">{duration}</span>
          </div>
          <h1 className="movie-title">{title}</h1>
          <p className="movie-synopsis">{synopsis}</p>
          <button className="book-button" onClick={handleBookTickets}>
            Book Tickets
          </button>
        </div>
        {/* Movie Poster */}
        <div className="movie-poster">
          <img src={poster} alt={title} />
        </div>
      </div>
    </div>
  );
}

export default SelectMovie;
