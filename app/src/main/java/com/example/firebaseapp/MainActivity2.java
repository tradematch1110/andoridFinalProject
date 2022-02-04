package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.firebaseapp.databinding.ActivityMain2Binding;
import com.example.firebaseapp.databinding.ActivityMain3Binding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        @NonNull ActivityMain2Binding binding = ActivityMain2Binding.inflate(getLayoutInflater());

        View view = binding.getRoot();


    }
}