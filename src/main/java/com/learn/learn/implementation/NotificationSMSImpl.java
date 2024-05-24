package com.learn.learn.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.learn.models.SMSNotification;
import com.learn.learn.repository.NotificationSMSRepository;

@Service
public class NotificationSMSImpl extends SMSNotification {
    private NotificationSMSRepository smsNotificationRepository;

    public NotificationSMSImpl(NotificationSMSRepository smsNotificationRepository) {
        this.smsNotificationRepository = smsNotificationRepository;
    }

    public List<SMSNotification> saveAllNotification(List<SMSNotification> listSmsNotification) {
        return smsNotificationRepository.saveAll(listSmsNotification);
    }

    public List<SMSNotification> findAll() {
        return smsNotificationRepository.findAll();
    }

    SMSNotification findById(String id) {
        return smsNotificationRepository.findById(id).orElse(null);
    }

    void deleteAllById(String ids) {
        smsNotificationRepository.deleteAllById(ids);
    }
}