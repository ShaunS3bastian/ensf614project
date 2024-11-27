import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

export const sendNotification = async (userId, title, message) => {
    const response = await axios.post(`${API_URL}/notifications/send`, null, {
        params: { userId, title, message },
    });
    return response.data;
};

export const getUserNotifications = async (userId) => {
    const response = await axios.get(`${API_URL}/notifications/user/${userId}`);
    return response.data;
};
