package com.example.firebaseapp.services;

import com.example.firebaseapp.DayOfWeek;

public interface DayOfWeekDelegate {

    void onSuccess(DayOfWeek dayOfWeek);

    void onError();
}
