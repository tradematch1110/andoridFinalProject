package com.example.firebaseapp;

import java.util.Date;

public class AppointmentDetails {
    private String username;
    private Date hour;

    @Override
    public String toString() {
        return "AppointmentDetails{" +
                "username='" + username + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }

    public AppointmentDetails() {}
    public AppointmentDetails(String username, Date hour) {
        this.username = username;
        this.hour = hour;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }
}
