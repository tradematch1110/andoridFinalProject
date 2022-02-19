package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String userName;
    private String password;
    private String phoneText;
    private String mailText;
    long maxId=0;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("users").child(user.getId());
//        myRef.setValue(user);
        myRef = database.getReference().child("Users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxId=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public void loginFunction(){
        String email = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("result", "login ok ");
                        } else {
                            Log.d("result", "login fail ");
                        }

                        // ...
                    }
                });

    }
    public void regFunction(){
         userName = ((EditText)findViewById(R.id.userText)).getText().toString();
         password = ((EditText)findViewById(R.id.passText)).getText().toString();
         phoneText = ((EditText)findViewById(R.id.phoneText)).getText().toString();
         mailText = ((EditText)findViewById(R.id.mailText)).getText().toString();


        mAuth.createUserWithEmailAndPassword(mailText, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            addData();
                            Log.d("result", "register ok ");
                        } else {
                            Log.d("result", "register fail ");
                        }

                        // ...
                    }
                });

    }
    public void addData(){

        User user = new User(userName , mailText , phoneText);

        Log.d("result" , "oop");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxId=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myRef.child(String.valueOf(maxId+1)).setValue(user);

    }
    public void getData(){

    }
}