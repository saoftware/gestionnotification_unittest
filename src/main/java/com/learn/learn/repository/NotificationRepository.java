package com.learn.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.learn.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, String> {
    
}
