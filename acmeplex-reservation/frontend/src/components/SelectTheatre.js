import React from "react";
import { useNavigate, useLocation } from "react-router-dom";
import "./SelectTheatre.css";

function SelectTheatre() {
  const location = useLocation();
  const navigate = useNavigate();

  // Movie details passed via state
  const { state } = location;
  const movieTitle = state?.title || "Unknown Movie";

  // Data for theatres
  const theatres = [
    {
      name: "Scotiabank Theatre Chinook",
      address: "6455 Macleod Trail SW, Calgary, AB, Canada, T2H 0K8",
      image: "./images/scotiabank-theatre.png",
    },
    {
      name: "Landmark Cinemas Market Mall",
      address: "3625 Shaganappi Trail NW, Calgary, AB, Canada, T3A 0E2",
      image: "./images/landmark-cinemas.png",
    },
    {
      name: "Globe Cinema",
      address: "617 8 Ave SW, Calgary, AB, Canada, T2P 1H1",
      image: "./images/globe-cinema.png",
    },
  ];

  const handleBuyNow = (theatre) => {
    navigate("/select-showtime", {
      state: {
        title: movieTitle,
        theatreName: theatre.name,
        address: theatre.address,
      },
    });
  };

  return (
    <div className="select-theatre-container">
      {/* Back Button */}
      <button className="back-button" onClick={() => navigate(-1)}>
        &#8592; Back
      </button>
      {/* Page Title */}
      <h1 className="page-title">Select Theatre</h1>
      {/* Movie Title */}
      <h2 className="movie-title">Movie: {movieTitle}</h2>
      {/* Theatre List */}
      <div className="theatre-list">
        {theatres.map((theatre, index) => (
          <div key={index} className="theatre-card">
            <img
              src={theatre.image}
              alt={theatre.name}
              className="theatre-image"
            />
            <div className="theatre-info">
              <h3 className="theatre-name">{theatre.name}</h3>
              <p className="theatre-address">{theatre.address}</p>
              <button
                className="buy-now-button"
                onClick={() => handleBuyNow(theatre)}
              >
                Buy Now
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default SelectTheatre;
