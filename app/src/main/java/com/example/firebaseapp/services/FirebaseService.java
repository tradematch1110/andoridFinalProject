package com.example.firebaseapp.services;

import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.firebaseapp.AppointmentDetails;
import com.example.firebaseapp.Day;
import com.example.firebaseapp.DayOfWeek;
import com.example.firebaseapp.LoginDelegate;
import com.example.firebaseapp.R;
import com.example.firebaseapp.SelectedDate;
import com.example.firebaseapp.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseService {
    private static User user;
    private static DayOfWeek day;
    private static SelectedDate selectedDate;
    public static void addUser(String userName, String mailText, String phoneText){

        User user = new User(userName , mailText , phoneText);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        myRef.setValue(user);

    }
    public static User getUser(){
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference uidRef = rootRef.child("Users").child(uid);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                Log.d("TAG", user.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("TAG", databaseError.getMessage()); //Don't ignore errors!
            }
        };
        uidRef.addListenerForSingleValueEvent(valueEventListener);
        return user;
    }

    public static void createDayOfWeek( DayOfWeek dayOfWeek){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("DaysOfWeek");
        myRef.push().setValue(dayOfWeek);
//        DatabaseReference myRef = database.getReference("DaysOfWeek").child(dayOfWeek.getDayNumber()+"");

    }

    public static DayOfWeek getDayOfWeek(int dayNumber){
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("DaysOfWeek");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    try {
                        for (DataSnapshot post : snapshot.getChildren())
                        {
                            DayOfWeek day1 = post.getValue(DayOfWeek.class);
                        }
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                        Log.d("TAG", "", ex);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        return day;
    }

    public static void addDay(Day day){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Days").child(day.getDate());
        myRef.setValue(day);
    }

    public static void addSelectedDate(SelectedDate selectedDate, String date){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("SelectedDates").child(date);
//        myRef.setValue(selectedDate);
        myRef.push().setValue(selectedDate.getAppointmentDetails());
    }


    public static boolean isAppointmentExists(SelectedDate selectedDate){
////        SelectedDate test = getSelectedDate(selectedDate);
//        if(test==null) return false;

        return true;
    }
//    public static ArrayList<AppointmentDetails> getSelectedDate(SelectedDate selectedDate1, String date){

    public static ArrayList<AppointmentDetails> getSelectedDate( String date){
        ArrayList<AppointmentDetails> appointmentDetails = new ArrayList<>();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("SelectedDates/" + date);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    for (DataSnapshot post : dataSnapshot.getChildren())
                    {
                        appointmentDetails.add(post.getValue(AppointmentDetails.class));
                        Log.d("TAG", post.toString());

                    }

                } catch (Exception ex)
                {
                    ex.printStackTrace();
                    Log.d("TAG", "", ex);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("TAG", databaseError.getMessage()); //Don't ignore errors!
            }
        };
        ref.addValueEventListener(valueEventListener);
        return appointmentDetails;
    }



}
