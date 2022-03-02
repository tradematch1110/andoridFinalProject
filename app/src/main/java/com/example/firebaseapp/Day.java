package com.example.firebaseapp;

import java.util.HashMap;

public class Day {
    private boolean isOff;
    private String date;
    private double breakHourStrat;
    private double breakHourEnd;
    private int dayNumber;

    public Day() {
    }

    public Day(boolean isOff, String date, double breakHourStrat, double breakHourEnd, int dayNumber) {
        this.isOff = isOff;
        this.date = date;
        this.breakHourStrat = breakHourStrat;
        this.breakHourEnd = breakHourEnd;
        this.dayNumber = dayNumber;
    }

    public double getBreakHourStrat() {
        return breakHourStrat;
    }

    public void setBreakHourStrat(double breakHourStrat) {
        this.breakHourStrat = breakHourStrat;
    }

    public double getBreakHourEnd() {
        return breakHourEnd;
    }

    public void setBreakHourEnd(double breakHourEnd) {
        this.breakHourEnd = breakHourEnd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Day(String date) {
        this.date = date;
    }

    public boolean isOff() {
        return isOff;
    }

    public void setOff(boolean off) {
        isOff = off;
    }


}
