import React from "react";
import MovieCard from "./MovieCard";
import "./MovieSection.css";

function MovieSection({ title, movies, onMovieClick }) {
  return (
    <section className="movie-section">
      <h2 className="section-title">{title}</h2>
      <div className="movie-list">
        {movies.map((movie, index) => (
          <MovieCard key={index} movie={movie} onClick={() => onMovieClick(movie)} />
        ))}
      </div>
    </section>
  );
}

export default MovieSection;
