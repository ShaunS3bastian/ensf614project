import React from "react";
import "./styles/HomePage.css";

const HomePage = () => {
    const movies = {
        advanceTickets: [
            {
                title: "Mufasa",
                img: "C:\Users\91989\Desktop\acmeplex-reservation\Movie-Posters\Mufasa.jpeg", // Replace with actual image paths
            },
            {
                title: "Better Man",    
                img: "C: \Users\91989\Desktop\acmeplex- reservation\Movie - Posters\Better Man.jpeg",
            },
            {
                title: "Kraven the Hunter",
                img: "C: \Users\91989\Desktop\acmeplex- reservation\Movie - Posters\Better Man.jpeg",
            },
        ],
        nowShowing: [
            {
                title: "The Wild Robot",
                img: "C: \Users\91989\Desktop\acmeplex- reservation\Movie - Posters\Better Man.jpeg",
            },
            {
                title: "Spider-Man: No Way Home",
                img: "C: \Users\91989\Desktop\acmeplex- reservation\Movie - Posters\SpiderMan.png",
            },
            {
                title: "Gladiator",
                img: "C:\Users\91989\Desktop\acmeplex-reservation\Movie-Posters\Gladiator II.jpeg",
            },
        ],
    };

    const handleSelectMovie = (movieTitle) => {
        alert(`Selected Movie: ${movieTitle}`);
        // Add logic for navigating to a movie details page or booking flow
    };


    return (
        <div className="home-page">
            <header className="header">
                <div className="logo">ACMEPLEX</div>
                <div className="nav-links">
                    <span>All Movies</span>
                    <span>My Tickets</span>
                </div>
                <div className="profile-icon">👤</div>
            </header>
            <main>
                <section className="advance-tickets">
                    <h2>Advance Tickets Available</h2>
                    <div className="movie-grid">
                        {movies.advanceTickets.map((movie, index) => (
                            <div key={index} className="movie-card">
                                <img src={movie.img} alt={movie.title} className="movie-image" />
                                <p className="movie-title">{movie.title}</p>
                            </div>
                        ))}
                    </div>
                </section>
                <section className="now-showing">
                    <h2>Now Showing</h2>
                    <div className="movie-grid">
                        {movies.nowShowing.map((movie, index) => (
                            <div key={index} className="movie-card">
                                <img src={movie.img} alt={movie.title} className="movie-image" />
                                <p className="movie-title">{movie.title}</p>
                            </div>
                        ))}
                    </div>
                </section>
            </main>
        </div>
    );
};

{
    movies.nowShowing.map((movie, index) => (
        <div key={index} className="movie-card">
            <img src={movie.img} alt={movie.title} className="movie-image" />
            <div className="overlay">
                <button
                    className="select-movie-button"
                    onClick={() => handleSelectMovie(movie.title)}
                >
                    Select Movie
                </button>
            </div>
            <p className="movie-title">{movie.title}</p>
        </div>
    ))
}
          </div >
        </section >
      </main >
    </div >
  );
}

export default HomePage;