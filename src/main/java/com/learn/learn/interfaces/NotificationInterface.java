package com.learn.learn.interfaces;

import java.util.List;

import com.learn.learn.models.Notification;

public interface NotificationInterface <T extends Notification> {
    List<Notification> saveAllNotification(List<Notification> notifications);
    List<Notification> findAll();
    /*
     * Mise a jour des notifications.
     * 
     * @param identifiant (String) identifier de la notification
     * @param notification (notification) le payload
     * 
     * @return {Notification} the notification saved
     */
    T miseAJourNotification(String identifiant, T payload);
}