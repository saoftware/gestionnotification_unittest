package com.learn.learn.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.learn.interfaces.NotificationInterface;
import com.learn.learn.models.Notification;
import com.learn.learn.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationInterface {
    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> saveAllNotification(List<Notification> notifications) {
        return this.notificationRepository.saveAll(notifications);
    }
}
