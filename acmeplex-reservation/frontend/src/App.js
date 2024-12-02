import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Login from "./components/Login";
import CreateAccount from "./components/CreateAccount";
import RegisteredHomepage from "./components/RegisteredHomepage";
import GuestHomepage from "./components/GuestHomepage";
import SelectMovie from "./components/SelectMovie";
import SelectAdvanceMoviePage from "./components/SelectAdvanceMoviePage";
import SelectTheatre from "./components/SelectTheatre";
import SelectShowtime from "./components/SelectShowtime";
import SelectSeat from "./components/SelectSeat";
import PaymentPage from "./components/PaymentPage";
import CardDetails from "./components/CardDetails";
import ConfirmPaymentPage from "./components/ConfirmPaymentPage";
import CancelTickets from "./components/CancelTickets";
import CancelTicketConfirmation from "./components/CancelTicketConfirmation"; // Import the new confirmation component
import "./App.css";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [isGuest, setIsGuest] = useState(false);
  const [searchQuery, setSearchQuery] = useState("");

  const handleSearch = (query) => {
    setSearchQuery(query.toLowerCase());
  };

  const movies = {
    "Coming Soon": [
      {
        title: "Mufasa",
        poster: "./images/Mufasa.png",
        genres: ["Adventure"],
        duration: "1h 58m",
        synopsis:
          "A prequel to The Lion King, exploring Mufasa's rise to become king of the Pride Lands.",
      },
      {
        title: "Better Man",
        poster: "./images/Better Man.png",
        genres: ["Biography"],
        duration: "2h 10m",
        synopsis:
          "The story of Robbie Williams, exploring the highs and lows of his extraordinary career.",
      },
      {
        title: "Kraven",
        poster: "./images/Kraven.png",
        genres: ["Action"],
        duration: "1h 55m",
        synopsis:
          "A Marvel anti-hero embarks on a journey to become one of the most feared hunters in the world.",
      },
    ],
    "Now Showing": [
      {
        title: "The Wild Robot",
        poster: "./images/The Wild Robot.png",
        genres: ["Animation"],
        duration: "1h 30m",
        synopsis:
          "An abandoned robot learns to adapt and survive in the wilderness, befriending the animals around her.",
      },
      {
        title: "Spider-Man: No Way Home",
        poster: "./images/Spidey.png",
        genres: ["Action"],
        duration: "2h 13m",
        synopsis:
          "With Spider-Man’s identity now revealed, Peter Parker struggles to separate his normal life from the high stakes of being a superhero.",
      },
      {
        title: "Gladiator",
        poster: "./images/Gladiator II.png",
        genres: ["Action"],
        duration: "2h 40m",
        synopsis:
          "A former Roman general seeks vengeance against the corrupt emperor who murdered his family and sent him into slavery.",
      },
    ],
  };

  const filteredMovies = Object.keys(movies).reduce((result, section) => {
    result[section] = movies[section].filter((movie) =>
      movie.title.toLowerCase().includes(searchQuery)
    );
    return result;
  }, {});

  const handleLogin = () => {
    setIsLoggedIn(true);
    setIsGuest(false);
  };

  const handleGuestLogin = () => {
    setIsGuest(true);
    setIsLoggedIn(false);
  };

  return (
    <Router>
      <div className="App">
        <Routes>
          {/* Login Page */}
          <Route
            path="/"
            element={
              isLoggedIn ? (
                <Navigate to="/registered-homepage" />
              ) : isGuest ? (
                <Navigate to="/guest-homepage" />
              ) : (
                <Login onLogin={handleLogin} onGuestLogin={handleGuestLogin} />
              )
            }
          />
          {/* Create Account Page */}
          <Route path="/create-account" element={<CreateAccount />} />
          {/* Registered User Homepage */}
          <Route
            path="/registered-homepage"
            element={
              isLoggedIn ? (
                <RegisteredHomepage movies={filteredMovies} onSearch={handleSearch} />
              ) : (
                <Navigate to="/" />
              )
            }
          />
          {/* Guest User Homepage */}
          <Route
            path="/guest-homepage"
            element={
              isGuest ? (
                <GuestHomepage movies={filteredMovies} onSearch={handleSearch} />
              ) : (
                <Navigate to="/" />
              )
            }
          />
          {/* Select Movie Pages */}
          <Route path="/select-movie" element={<SelectMovie />} />
          <Route path="/select-advance-movie" element={<SelectAdvanceMoviePage />} />
          {/* Select Theatre Page */}
          <Route path="/select-theatre" element={<SelectTheatre />} />
          {/* Select Showtime Page */}
          <Route path="/select-showtime" element={<SelectShowtime />} />
          {/* Select Seat Page */}
          <Route path="/select-seat" element={<SelectSeat />} />
          {/* Payment Page */}
          <Route path="/payment" element={<PaymentPage />} />
          {/* Card Details Page */}
          <Route path="/card-details" element={<CardDetails />} />
          {/* Confirm Payment Page */}
          <Route path="/confirm-payment" element={<ConfirmPaymentPage />} />
          {/* Cancel Tickets Page */}
          <Route path="/cancel-tickets" element={<CancelTickets />} />
          {/* Cancel Ticket Confirmation Page */}
          <Route path="/cancel-ticket-confirmation" element={<CancelTicketConfirmation />} />
          {/* Fallback for undefined routes */}
          <Route path="*" element={<div>Page Not Found</div>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
