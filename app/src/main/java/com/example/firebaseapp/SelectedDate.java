package com.example.firebaseapp;

import java.util.HashMap;

public class SelectedDate {
    private String date;
    private HashMap<String, AppointmentDetails> appointment;
    private int dayNumber;

    // constructor
    public SelectedDate(String date, int dayNumber) {
        this.date = date;
        this.dayNumber=dayNumber;
        appointment = new HashMap<>();
    }
    public HashMap<String, AppointmentDetails> getAppointment() {
        return appointment;
    }

    public void setAppointment(HashMap<String, AppointmentDetails> appointment) {
        this.appointment = appointment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }


}
