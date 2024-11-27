package com.acmeplex.service;

import com.acmeplex.model.Notification;
import com.acmeplex.model.User;
import com.acmeplex.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(Long userId, String title, String message) {
        Notification notification = new Notification();
        notification.setUser(new User(userId)); // Minimal User instance
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setSentDate(LocalDateTime.now());

        notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}
