package com.example.firebaseapp.services;

import com.example.firebaseapp.Day;

public interface DayDelegate {

    void onSuccess(Day day);

    void onError();
}
