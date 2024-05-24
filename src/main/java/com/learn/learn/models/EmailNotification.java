package com.learn.learn.models;

import jakarta.persistence.Entity;

@Entity
public class EmailNotification extends Notification {
    private String email;

    @Override
    public String toString() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
