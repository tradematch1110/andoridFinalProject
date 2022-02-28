package com.example.firebaseapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyListView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyListView extends Fragment {

    private TextView date;

    public DailyListView() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_list_view, container, false);
        date = view.findViewById(R.id.textView2);
        // Inflate the layout for this fragment
        return view;
    }
}