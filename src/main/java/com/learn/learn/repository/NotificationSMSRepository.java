package com.learn.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.learn.models.SMSNotification;

public interface NotificationSMSRepository extends JpaRepository<SMSNotification, String> {
    void deleteAllById(String id);
}
