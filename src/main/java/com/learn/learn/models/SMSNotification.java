package com.learn.learn.models;

import jakarta.persistence.Entity;

@Entity
public class SMSNotification extends Notification {
    private String numeroTelephone;

    @Override
    public String toString() {
        return this.numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
}
