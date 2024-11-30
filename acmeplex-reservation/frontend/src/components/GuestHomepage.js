import React from "react";
import Header from "./Header";
import MovieSection from "./MovieSection";
import Footer from "./Footer";
import { useNavigate } from "react-router-dom";
import "./GuestHomepage.css";

function GuestHomepage({ movies, onSearch }) {
  const navigate = useNavigate();

  const handleMovieClick = (movie) => {
    navigate("/select-movie", { state: movie });
  };

  const handleCancelTickets = () => {
    alert("Cancel Tickets functionality will be implemented!");
  };

  return (
    <div className="guest-homepage">
      <Header onSearch={onSearch} />
      <div className="button-container">
        <button className="action-button" onClick={handleCancelTickets}>
          Cancel Tickets
        </button>
      </div>
      <MovieSection
        title="Now Showing"
        movies={movies["Now Showing"]}
        onMovieClick={handleMovieClick}
      />
      <Footer />
    </div>
  );
}

export default GuestHomepage;
