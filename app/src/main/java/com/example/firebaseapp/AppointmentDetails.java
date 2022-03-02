package com.example.firebaseapp;

public class AppointmentDetails {
    private String date;
    private String hour;

    public AppointmentDetails(String date, String hour) {
        this.date = date;
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
