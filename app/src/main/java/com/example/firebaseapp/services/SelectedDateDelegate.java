package com.example.firebaseapp.services;

import com.example.firebaseapp.AppointmentDetails;

import java.util.ArrayList;

public interface SelectedDateDelegate {

    void onSuccess(ArrayList<AppointmentDetails> appointmentDetailsArrayList);

    void onError();
}
