package com.learn.learn.interfaces;

import java.util.List;

import com.learn.learn.models.SMSNotification;

public interface NotificationSMSInterface {
    SMSNotification add(SMSNotification notification);
    List<SMSNotification> findAll();
    SMSNotification findById(String ids);
    void deleteAllById(String ids);
}
