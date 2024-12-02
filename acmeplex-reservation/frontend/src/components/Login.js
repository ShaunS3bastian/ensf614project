import React from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";
import logo from "../assets/acmeplex-logo.png"; // Adjust the path to match your directory

function Login({ onLogin, onGuestLogin }) {
  const navigate = useNavigate();

  const handleRegisteredLogin = (e) => {
    e.preventDefault();
    onLogin();
    navigate("/registered-homepage");
  };

  const handleGuestLogin = () => {
    onGuestLogin();
    navigate("/guest-homepage");
  };

  return (
    <div className="login-container">
      <img src={logo} alt="ACMEPLEX Logo" className="login-logo" />
      <h1 className="login-title">Login to Your Account</h1>
      <form className="login-form" onSubmit={handleRegisteredLogin}>
        <input
          type="email"
          placeholder="Email"
          className="login-input"
          required
        />
        <input
          type="password"
          placeholder="Password"
          className="login-input"
          required
        />
        <button type="submit" className="login-button">
          Log In
        </button>
        <button type="button" className="guest-button" onClick={handleGuestLogin}>
          Guest Account
        </button>
      </form>
      <p className="signup-text">
        Don’t have an account?{" "}
        <span
          className="signup-link"
          onClick={() => navigate("/create-account")}
        >
          Create Account
        </span>
      </p>
    </div>
  );
}

export default Login;
