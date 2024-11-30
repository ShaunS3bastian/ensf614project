import React from "react";
import { useNavigate } from "react-router-dom";
import logo from "../assets/acmeplex-logo.png";
import "./Login.css";

function Login({ onLogin, onGuestLogin }) {
  const navigate = useNavigate();

  const handleRegisteredLogin = (e) => {
    e.preventDefault();
    onLogin(); // Trigger registered login
    navigate("/registered-homepage"); // Redirect to Registered User Homepage
  };

  const handleGuestLogin = () => {
    onGuestLogin(); // Trigger guest login
    navigate("/guest-homepage"); // Redirect to Guest Homepage
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
        <button
          type="button"
          className="guest-button"
          onClick={handleGuestLogin}
        >
          Sign up as Guest
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
