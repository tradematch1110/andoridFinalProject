package com.example.firebaseapp;

import java.util.Date;

public class Line {
    private Date startTime;
    private Date endTime;
    private String username = "";
    private boolean isBreak;

    public Line() {
    }

    public Line(Date startTime, Date endTime, String username, boolean isBreak) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.username = username;
        this.isBreak = isBreak;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isBreak() {
        return isBreak;
    }

    public void setBreak(boolean aBreak) {
        isBreak = aBreak;
    }

    @Override
    public String toString() {
        return "Line{" +
                "openHour=" + startTime +
                ", closeHour=" + endTime +
                ", username='" + username + '\'' +
                ", isBreak=" + isBreak +
                '}';
    }
}
