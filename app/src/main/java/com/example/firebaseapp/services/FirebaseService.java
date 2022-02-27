package com.example.firebaseapp.services;

import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.firebaseapp.LoginDelegate;
import com.example.firebaseapp.R;
import com.example.firebaseapp.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseService {

    public static void addUser(String userName, String mailText, String phoneText){

        User user = new User(userName , mailText , phoneText);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        myRef.setValue(user);

    }
    public void getUser(){

    }
}
