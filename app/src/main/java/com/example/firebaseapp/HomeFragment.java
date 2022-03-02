package com.example.firebaseapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseapp.services.FirebaseService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeFragment extends Fragment {
//    SharedPreferences sharedPreferences;
    TextView date;
    private ArrayList<DataModel> dataSet;
//    private AppCompatActivity appCompatActivity;
    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;
    private CustomAdapter addapter;

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
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.get(Calendar.DAY_OF_WEEK);
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String d = simpleDateFormat.format(new Date());


        date.setText(now.format("%d/%m/%Y"));
        recycleView = view.findViewById(R.id.my_recycler_view);

        layoutManager = new LinearLayoutManager(getActivity()); // new GridLayoutManager
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<DataModel>();

        for(int i=0 ; i<MyData.nameArray.length ; i++)
        {
            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i]

            ));
        }

        addapter = new CustomAdapter(dataSet);
        recycleView.setAdapter(addapter);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
//                Toast.makeText(getContext(), "Selected date: "+ dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_LONG).show();
                String selectedDate = dayOfMonth+"/"+(month+1)+"/"+year;
                date.setText(selectedDate);
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                int dayNumber = calendar.get(Calendar.DAY_OF_WEEK);
                String selectedDateToDB = dayOfMonth+""+(month+1)+""+year;

//           *******  add day to database **************
//                Day day = new Day();
//                day.setDayNumber(dayNumber);
//                day.setOff(true);
//                day.setDate(selectedDateToDB);
//                FirebaseService.addDay(day);


//           *******  add dayOfWeek1 to database **************
//                DayOfWeek dayOfWeek1 = new DayOfWeek(dayNumber, false,8.30, 14.00, 0, 0);
//                FirebaseService.createDayOfWeek(dayOfWeek1);
//                Toast.makeText(getContext(), "DAY_OF_WEEK: "+ dayOfWeek, Toast.LENGTH_LONG).show();

                //Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_DailyListView);

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}