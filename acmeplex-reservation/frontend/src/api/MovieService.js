import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

export const getAllMovies = async () => {
    const response = await axios.get(`${API_URL}/movies`);
    return response.data;
};

export const getShowtimesForMovie = async (movieId) => {
    const response = await axios.get(`${API_URL}/showtimes/movie/${movieId}`);
    return response.data;
};
