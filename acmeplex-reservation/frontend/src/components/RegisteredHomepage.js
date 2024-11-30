import React from "react";
import Header from "./Header";
import MovieSection from "./MovieSection";
import Footer from "./Footer";
import { useNavigate } from "react-router-dom";
import "./RegisteredHomepage.css";

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
    alert("Cancel Tickets functionality will be implemented!");
  };

  const handleLogout = () => {
    window.location.href = "/";
  };

  return (
    <div className="registered-homepage">
      <Header onSearch={onSearch} />
      <div className="button-container">
        <button className="action-button" onClick={handleCancelTickets}>
          Cancel Tickets
        </button>
        <button className="action-button" onClick={handleLogout}>
          Log Out
        </button>
      </div>
      <MovieSection
        title="Advance Tickets Available"
        movies={movies["Coming Soon"]}
        onMovieClick={(movie) => handleMovieClick(movie, true)}
      />
      <MovieSection
        title="Now Showing"
        movies={movies["Now Showing"]}
        onMovieClick={(movie) => handleMovieClick(movie, false)}
      />
      <Footer />
    </div>
  );
}

export default RegisteredHomepage;
