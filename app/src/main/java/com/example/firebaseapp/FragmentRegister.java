package com.example.firebaseapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseapp.services.FirebaseService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FragmentRegister extends Fragment {

    private TextView userName;
    private TextView password;
    private TextView phoneText;
    private TextView mailText;

    private FirebaseAuth mAuth;

    public FragmentRegister() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);

        this.mAuth = FirebaseAuth.getInstance();
        this.userName = view.findViewById(R.id.userText);
        this.password = view.findViewById(R.id.passText);
        this.phoneText = view.findViewById(R.id.phoneText);
        this.mailText = view.findViewById(R.id.mailText);

        Button button = view.findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(mailText.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseService.addUser(userName.getText().toString(), mailText.getText().toString(), phoneText.getText().toString());
                            Navigation.findNavController(view).navigate(R.id.action_fragmentRegister_to_fragmentLog);
                        } else
                        {
                            Toast.makeText(getActivity(), "Error cannot register new user", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


        return view;
    }
}