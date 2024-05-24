package com.learn.learn;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.learn.learn.interfaces.NotificationInterface;
import com.learn.learn.models.Notification;
import com.learn.learn.repository.NotificationRepository;
import com.learn.learn.services.NotificationService;

class ApplicationTest extends LearnApplicationTests {

    @Autowired private NotificationRepository notificationRepository;
    @Autowired private NotificationInterface notificationInterface;


    @Test
    @Transactional
    void init() {
        System.out.println("Hello Test");
        long nombreNotification = notificationRepository.count();
        Assert.assertEquals(1L, nombreNotification);
    } 
    
    @Test
    void when_get_list_notification_then_ok() {
        try {
            mvc.perform(
                MockMvcRequestBuilders
                    .get("/notifications")
                    .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void given_notification_payload_then_update() {
        Notification notification = new Notification();
        notification.setId(null);
        notification.setNom("Nom");
        notification.setPrenom("prenom");
        notification.setDateCreation(new Date());

        notificationInterface.miseAJourNotification("1", notification);
    }
}
