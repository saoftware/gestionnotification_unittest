package com.learn.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.learn.models.EmailNotification;

public interface NotificationEmailRepository extends JpaRepository<EmailNotification, String> {
    
}
