package com.example.firebaseapp;

import java.util.HashMap;

public class DayOfWeek {
    private int dayNumber;
    private boolean isOff;
    private double openHour;
    private double closeHour;
    private double breakHourStrat;
    private double breakHourEnd;


    public DayOfWeek(int dayNumber, boolean isOff, double openHour, double closeHour, double breakHourStrat, double breakHourEnd) {
        this.dayNumber = dayNumber;
        this.isOff = isOff;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.breakHourStrat = breakHourStrat;
        this.breakHourEnd = breakHourEnd;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public boolean isOff() {
        return isOff;
    }

    public void setOff(boolean off) {
        isOff = off;
    }

    public double getOpenHour() {
        return openHour;
    }

    public void setOpenHour(double openHour) {
        this.openHour = openHour;
    }

    public double getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(double closeHour) {
        this.closeHour = closeHour;
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

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "dayNumber=" + dayNumber +
                ", isOff=" + isOff +
                ", openHour=" + openHour +
                ", closeHour=" + closeHour +
                ", breakHourStrat=" + breakHourStrat +
                ", breakHourEnd=" + breakHourEnd +
                '}';
    }

}
