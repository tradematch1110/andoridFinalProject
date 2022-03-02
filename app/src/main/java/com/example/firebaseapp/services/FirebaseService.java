package com.example.firebaseapp.services;

import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.firebaseapp.AppointmentDetails;
import com.example.firebaseapp.Day;
import com.example.firebaseapp.DayOfWeek;
import com.example.firebaseapp.LoginDelegate;
import com.example.firebaseapp.R;
import com.example.firebaseapp.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FirebaseService {

    public static void addUser(String userName, String mailText, String phoneText){

        User user = new User(userName , mailText , phoneText);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        myRef.setValue(user);

    }
    public void getUser(){

    }

    public static void createDayOfWeek( DayOfWeek dayOfWeek){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("DaysOfWeek").child(dayOfWeek.getDayNumber()+"");
        myRef.setValue(dayOfWeek);
    }
    public static void addDay(Day day){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Days").child(day.getDate());
        myRef.setValue(day);
    }
}
