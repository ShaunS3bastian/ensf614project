import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

export const bookTicket = async (ticketDetails) => {
    const response = await axios.post(`${API_URL}/tickets/book`, ticketDetails);
    return response.data;
};

export const cancelTicket = async (ticketId, isRegisteredUser) => {
    const response = await axios.post(`${API_URL}/tickets/cancel/${ticketId}`, null, {
        params: { isRegisteredUser },
    });
    return response.data;
};

export const getUserTickets = async (userId) => {
    const response = await axios.get(`${API_URL}/tickets/user/${userId}`);
    return response.data;
};
