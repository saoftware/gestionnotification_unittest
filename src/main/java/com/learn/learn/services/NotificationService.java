package com.learn.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.learn.interfaces.NotificationInterface;
import com.learn.learn.models.Notification;

@Service
public class NotificationService {
    @Autowired NotificationInterface notificationInterface;

    public List<Notification> saveAll(List<Notification> listNotifications) {
        return notificationInterface.saveAllNotification(listNotifications);
    }

    public List<Notification> findAll() {
        return notificationInterface.findAll();
    }
}
