package com.example.firebaseapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

public class HomeFragment extends Fragment {
//    SharedPreferences sharedPreferences;
    TextView date;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//        String key = sharedPreferences.getString("KEY", null);
//        sharedPreferences.edit().putString("KEY", "ddddd").apply();

        CalendarView calendarView = view.findViewById(R.id.calendarView3);
        date = view.findViewById(R.id.textView);
        Time now = new Time();
        now.setToNow();
        date.setText(now.format("%d/%m/%Y"));

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
//                Toast.makeText(getContext(), "Selected date: "+ dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_LONG).show();
                date.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                //Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_DailyListView);

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}