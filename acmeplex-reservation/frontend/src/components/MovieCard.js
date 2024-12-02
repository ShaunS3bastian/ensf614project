import React from "react";
import "./MovieCard.css";

function MovieCard({ movie, onClick }) {
  return (
<div
  className="movie-card"
  onClick={onClick}
  role="button"
  aria-label={`Select movie: ${movie.title}`}
>
  <img
    src={movie.poster}
    alt={`Poster of ${movie.title}`}
    className="movie-poster"
  />
  <div className="movie-title">{movie.title}</div>
</div>

  );
}

export default MovieCard;
