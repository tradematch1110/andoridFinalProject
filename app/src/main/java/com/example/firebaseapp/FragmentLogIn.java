package com.example.firebaseapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FragmentLogIn extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log, container, false);
        Button button = view.findViewById(R.id.buttonRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentLog_to_fragmentRegister);

//                MainActivity ma = (MainActivity) getActivity();
//                ma.regFunction();
            }
        });

        Button buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity ma = (MainActivity) getActivity();
                ma.loginFunction(new LoginDelegate() {
                    @Override
                    public void onSuccess() {
                        Navigation.findNavController(view).navigate(R.id.action_fragmentLog_to_homeFragment);
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(getActivity(), "Login error", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


        return view;
    }
}