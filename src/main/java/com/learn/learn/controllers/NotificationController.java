package com.learn.learn.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.learn.learn.models.Notification;
import com.learn.learn.services.NotificationService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class NotificationController {
    @Autowired NotificationService notificationService;

    @PostMapping("notification")
    @Operation(summary = "Create Notification", tags = {"notification"})
    public List<Notification> postMethodName(@RequestBody List<Notification> listNotifications) {        
        return notificationService.saveAll(listNotifications);
    }
    
}
