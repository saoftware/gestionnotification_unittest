package com.learn.learn.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.learn.learn.interfaces.NotificationInterface;
import com.learn.learn.models.EmailNotification;
import com.learn.learn.models.Notification;
import com.learn.learn.models.SMSNotification;
import com.learn.learn.repository.NotificationEmailRepository;
import com.learn.learn.repository.NotificationRepository;
import com.learn.learn.repository.NotificationSMSRepository;

@Service
public class NotificationServiceImpl <T extends Notification> implements NotificationInterface<T> {
    @Autowired private NotificationRepository notificationRepository;
    @Autowired private NotificationSMSRepository notificationSMSRepository;
    @Autowired private NotificationEmailRepository notificationEmailRepository;


    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> saveAllNotification(List<Notification> notifications) {
        return this.notificationRepository.saveAll(notifications);
    }

    public List<Notification> findAll() {
        return this.notificationRepository.findAll();
    }

    /*
     * Mise a jour des notifications.
     * 
     * @param identifiant (String) identifier de la notification
     * @param notification (notification) le payload
     * 
     * @return {Notification} the notification saved
     */
    public T miseAJourNotification(final String identifiant, final T payload) {
        Notification notification = notificationRepository
                .findById(identifiant)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Notification not found"
                    )
                );

        payload.setId(identifiant);
        if (payload instanceof Notification) {
            return notificationRepository.save(payload);
        } else if (payload instanceof SMSNotification) {
            return notificationSMSRepository.save(payload);
        } else {
            return notificationEmailRepository.save(payload);
        }
    }
}
