import React from "react";
import { useNavigate } from "react-router-dom";
import "./RegisteredHomepage.css";
import logo from "../assets/acmeplex-logo.png";

function RegisteredHomepage({ movies, onSearch }) {
  const navigate = useNavigate();

  const handleMovieClick = (movie, isAdvance) => {
    if (isAdvance) {
      navigate("/select-advance-movie", { state: movie });
    } else {
      navigate("/select-movie", { state: movie });
    }
  };

  const handleCancelTickets = () => {
    navigate("/cancel-tickets");
  };

  const handleLogout = () => {
    window.location.href = "/";
  };

  return (
    <div className="registered-homepage">
      {/* Header */}
      <header className="registered-header">
        <div className="brand-logo">
          <img src={logo} alt="ACMEPLEX Logo" className="logo" />
        </div>
        <div className="search-container">
          <input
            type="text"
            className="search-bar"
            placeholder="Search Movie"
            onChange={(e) => onSearch(e.target.value)}
          />
        </div>
        <div className="action-buttons-container">
          <button className="action-button" onClick={handleCancelTickets}>
            Cancel Tickets
          </button>
          <button className="action-button" onClick={handleLogout}>
            Sign Out
          </button>
        </div>
      </header>

      {/* Movie Sections */}
      <main className="movie-sections">
        {/* Advance Tickets Section */}
        <div className="movie-section">
          <h2 className="section-title">Advance Tickets Available</h2>
          <div className="movies-grid">
            {movies["Coming Soon"]?.map((movie) => (
              <div
                key={movie.title}
                className="movie-card"
                onClick={() => handleMovieClick(movie, true)}
              >
                <div className="movie-overlay">
                  <p>Select Movie</p>
                </div>
                <img src={movie.poster} alt={movie.title} className="movie-poster" />
                <p className="movie-title">{movie.title}</p>
              </div>
            ))}
          </div>
        </div>

        {/* Now Showing Section */}
        <div className="movie-section">
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
        </div>
      </main>
    </div>
  );
}

export default RegisteredHomepage;
