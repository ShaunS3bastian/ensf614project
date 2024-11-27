import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

export const loginUser = async (credentials) => {
    const response = await axios.post(`${API_URL}/users/login`, credentials);
    localStorage.setItem('token', response.data.token); // Save JWT for authenticated requests
    return response.data;
};

export const registerUser = async (userDetails) => {
    const response = await axios.post(`${API_URL}/users/register`, userDetails);
    return response.data;
};

export const getCurrentUser = async () => {
    const token = localStorage.getItem('token');
    if (!token) throw new Error('No token found');
    const response = await axios.get(`${API_URL}/users/me`, {
        headers: { Authorization: `Bearer ${token}` },
    });
    return response.data;
};

export const logout = () => {
    localStorage.removeItem('token');
};
