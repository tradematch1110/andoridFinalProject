package com.example.firebaseapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.firebaseapp.services.DayDelegate;
import com.example.firebaseapp.services.DayOfWeekDelegate;
import com.example.firebaseapp.services.FirebaseService;
import com.example.firebaseapp.services.SelectedDateDelegate;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {
//    SharedPreferences sharedPreferences;
    private String userDisplayName;
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
        userDisplayName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName().toString();

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
                    MyData.id_[i]

            ));
        }

        addapter = new CustomAdapter(dataSet);
        recycleView.setAdapter(addapter);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                //start show progressbar loading...
//                Toast.makeText(getContext(), "Selected date: "+ dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_LONG).show();
                String selectedDate = dayOfMonth+"/"+(month+1)+"/"+year;
                date.setText(selectedDate);
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                int dayNumber = calendar.get(Calendar.DAY_OF_WEEK);
                String selectedDateToDB = dayOfMonth+""+(month+1)+""+year;

//                DayOfWeek day =  FirebaseService.getDayOfWeek(dayNumber);


//           *******  add SelectedDate to DB **************
//                AppointmentDetails ad = new AppointmentDetails( userDisplayName ,new Date());
//                SelectedDate selectedDate1 = new SelectedDate( ad);
//                FirebaseService.addSelectedDate(selectedDate1, selectedDateToDB);

//           *******  getSelectedDate from DB **************
//                FirebaseService.getSelectedDate(selectedDateToDB);
//                Log.d("TAG", "home fragment: "+ FirebaseService.appointmentDetails.size()+"");

//           *******  add day to database **************
//                Day day = new Day();
//                day.setDayNumber(dayNumber);
//                day.setOff(true);
//                day.setDate(selectedDateToDB);
//                FirebaseService.addDay(day);

//           *******  get day to database **************
            //FirebaseService.getDay(selectedDateToDB);

//           *******  add dayOfWeek1 to database **************
                FirebaseService.getDayOfWeek(dayNumber, new DayOfWeekDelegate() {
                    @Override
                    public void onSuccess(DayOfWeek dayOfWeek) {
                        if (!dayOfWeek.isOff()) {
                            FirebaseService.getDay(selectedDateToDB, new DayDelegate() {
                                @Override
                                public void onSuccess(Day day) {
                                    FirebaseService.getSelectedDate(selectedDateToDB, new SelectedDateDelegate() {
                                        @Override
                                        public void onSuccess(ArrayList<AppointmentDetails> appointmentDetailsArrayList) {
                                            //present information to user
                                            //load adapter
                                            //hide progressbar
                                            createList(appointmentDetailsArrayList, dayOfWeek, day, year,  month, dayOfMonth);
                                        }

                                        @Override
                                        public void onError() {

                                        }
                                    });
                                }

                                @Override
                                public void onError() {

                                }
                            });
                        }
                    }

                    @Override
                    public void onError() {
                        //hide progressbar and show error dialog
                    }
                });
//                DayOfWeek dayOfWeek1 = new DayOfWeek(dayNumber, false,9, 19, 14, 16);
//                FirebaseService.createDayOfWeek(dayOfWeek1);
//                Toast.makeText(getContext(), "DAY_OF_WEEK: "+ dayOfWeek, Toast.LENGTH_LONG).show();

                //Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_DailyListView);

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    public void createList(ArrayList<AppointmentDetails> appointmentDetailsArrayList, DayOfWeek dayOfWeek, Day day ,int year, int month, int dayOfMonth ){

        Map<Date, AppointmentDetails> appointmentDetailsMap = new HashMap<>();
        for (AppointmentDetails appointment : appointmentDetailsArrayList)
        {
            appointmentDetailsMap.put(appointment.getHour(), appointment);
        }
//        day.getDayNumber();

        //      Calculation of working hours
        int openHour = (int) dayOfWeek.getOpenHour();
        double workingHours = dayOfWeek.getCloseHour() - dayOfWeek.getOpenHour();
        double totalAppointmentsForView = workingHours*4;

        //      Calculation of breaking hours
        int breakHour = (int) dayOfWeek.getBreakHourStrat();

        // init calendar Break hour start
        Calendar calendarBreakStart = Calendar.getInstance();
        calendarBreakStart.set(year, month, dayOfMonth, breakHour, 0);

        int breakHourEnd = (int) dayOfWeek.getBreakHourEnd();

        // init calendar Break hour end
        Calendar calendarBreakEnd = Calendar.getInstance();
        calendarBreakEnd.set(year, month+1, dayOfMonth, breakHourEnd, 0);

        // init calendar working hours
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month+1, dayOfMonth, openHour, 0);

        ArrayList<Line> lines = new ArrayList<>();

        for (int i=0; i<totalAppointmentsForView; i++){
            Line currentLine = new Line();
            currentLine.setStartTime(calendar.getTime());


            if(appointmentDetailsMap!=null && calendar.getTime().before(calendarBreakStart.getTime()) || calendar.getTime().after(calendarBreakEnd.getTime())) {
                if(appointmentDetailsMap.containsKey((Date)calendar.getTime()))
                    currentLine.setUsername(appointmentDetailsMap.get((Date)calendar.getTime()).getUsername());
            }


            if(calendar.getTime().after(calendarBreakStart.getTime()) && calendar.getTime().before(calendarBreakEnd.getTime())) {
                currentLine.setBreak(true);
            }
            calendar.add(Calendar.MINUTE, 15);
            currentLine.setEndTime(calendar.getTime());
            lines.add(currentLine);


        }



    }
}