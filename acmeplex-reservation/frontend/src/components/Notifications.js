import React, { useEffect, useState } from "react";
import { getUserNotifications } from "../api/NotificationService";

const Notifications = ({ userId }) => {
    const [notifications, setNotifications] = useState([]);

    useEffect(() => {
        const fetchNotifications = async () => {
            const data = await getUserNotifications(userId);
            setNotifications(data);
        };
        fetchNotifications();
    }, [userId]);

    return (
        <div>
            <h2>Your Notifications</h2>
            <ul>
                {notifications.map((notification) => (
                    <li key={notification.id}>
                        <h4>{notification.title}</h4>
                        <p>{notification.message}</p>
                        <p><small>Sent: {new Date(notification.sentDate).toLocaleString()}</small></p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Notifications;
