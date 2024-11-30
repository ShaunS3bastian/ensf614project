import React from "react";
import logo from "../assets/acmeplex-logo.png";
import searchIcon from "../assets/search-icon.svg";
import "./Header.css";

function Header({ onSearch }) {
  const handleInputChange = (e) => {
    onSearch(e.target.value);
  };

  return (
    <header className="header">
      <img src={logo} alt="ACMEPLEX Logo" className="logo" />
      <div className="search-container">
        <img src={searchIcon} alt="Search" className="search-icon" />
        <input
          type="text"
          className="search-bar"
          placeholder="Search Movie"
          onChange={handleInputChange}
        />
      </div>
    </header>
  );
}

export default Header;
