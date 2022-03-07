package com.example.firebaseapp;

import com.google.firebase.auth.FirebaseAuth;

public class AppointmentDetails {
    private String username;
    private String hour;

    @Override
    public String toString() {
        return "AppointmentDetails{" +
                "username='" + username + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }

    public AppointmentDetails() {}
    public AppointmentDetails(String username, String hour) {
        this.username = username;
        this.hour = hour;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
