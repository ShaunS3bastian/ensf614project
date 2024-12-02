import React from "react";
import { useNavigate } from "react-router-dom";
import "./GuestHomepage.css";
import logo from "../assets/acmeplex-logo.png";

function GuestHomepage({ movies, onSearch }) {
  const navigate = useNavigate();

  const handleMovieClick = (movie) => {
    navigate("/select-movie", { state: movie }); // Pass the entire movie object
  };

  const handleCancelTickets = () => {
    navigate("/cancel-tickets");
  };

  const handleLogoClick = () => {
    navigate("/"); // Navigate to the login page
  };

  return (
    <div className="guest-homepage">
      {/* Header */}
      <header className="guest-header">
        <div className="brand-logo" onClick={handleLogoClick}>
          <img src={logo} alt="ACMEPLEX Logo" className="login-logo" />
        </div>
        <div className="search-container">
          <input
            type="text"
            className="search-bar"
            placeholder="Search Movie"
            onChange={(e) => onSearch(e.target.value)}
          />
        </div>
        <button className="action-button" onClick={handleCancelTickets}>
          Cancel Tickets
        </button>
      </header>

      {/* Movies Section */}
      <main className="movies-container">
        <h2 className="section-title">Now Showing</h2>
        <div className="movies-grid">
          {movies["Now Showing"]?.map((movie) => (
              <div
                key={movie.title}
                className="movie-card"
                onClick={() => handleMovieClick(movie, false)}
              >
                <div className="movie-overlay">
                  <p>Select Movie</p>
                </div>
                <img src={movie.poster} alt={movie.title} className="movie-poster" />
                <p className="movie-title">{movie.title}</p>
              </div>
          ))}
        </div>
      </main>
    </div>
  );
}

export default GuestHomepage;
