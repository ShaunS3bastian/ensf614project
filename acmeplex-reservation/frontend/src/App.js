import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import HomePage from './components/HomePage';
import AdminDashboard from './components/AdminDashboard';
import TicketBooking from './components/TicketBooking';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route path="/home" element={<HomePage />} />
                <Route path="/admin/dashboard" element={<AdminDashboard />} />
                <Route path="/book-ticket" element={<TicketBooking />} />
            </Routes>
        </Router>
    );
};

export default App;
