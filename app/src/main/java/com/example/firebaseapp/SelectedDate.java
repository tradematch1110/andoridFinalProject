package com.example.firebaseapp;

import java.util.ArrayList;

public class SelectedDate {
    private AppointmentDetails appointmentDetails;
    // constructor
    public SelectedDate(AppointmentDetails appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    public AppointmentDetails getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(AppointmentDetails appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }




}
