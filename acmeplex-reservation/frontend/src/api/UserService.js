import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

export const registerUser = async (user) => {
    const response = await axios.post(`${API_URL}/users/register`, user);
    return response.data;
};

export const loginUser = async (email, password) => {
    const response = await axios.post(`${API_URL}/users/login`, { email, password });
    return response.data;
};

export const getUserById = async (userId) => {
    const response = await axios.get(`${API_URL}/users/${userId}`);
    return response.data;
};
