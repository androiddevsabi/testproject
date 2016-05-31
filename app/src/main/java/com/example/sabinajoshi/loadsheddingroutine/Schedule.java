package com.example.sabinajoshi.loadsheddingroutine;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sabina joshi on 19/04/2016.
 */
public class Schedule implements Parcelable {
    private String week;
    private String morningStart;
    private String morningStop;
    private String nightStart;
    private String nightStop;
    private String totalTime;

    protected Schedule(Parcel in) {
        week = in.readString();
        morningStart = in.readString();
        morningStop = in.readString();
        nightStart = in.readString();
        nightStop = in.readString();
    }

    public static final Creator<Schedule> CREATOR = new Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel in) {
            return new Schedule(in);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };

    public Schedule() {

    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setMorningStart(String morningStart) {
        this.morningStart = morningStart;
    }

    public void setMorningStop(String morningStop) {
        this.morningStop = morningStop;
    }

    public void setNightStart(String nightStart) {
        this.nightStart = nightStart;
    }

    public void setNightStop(String nightStop) {
        this.nightStop = nightStop;
    }

    public String getWeek() {
        Log.d("the week is",this.week);

        return week;

    }


    public String getMorningStart() {
        return morningStart;
    }

    public String getMorningStop() {
        return morningStop;
    }

    public String getNightStart() {
        return nightStart;
    }

    public String getNightStop() {
        return nightStop;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(week);
        dest.writeString(morningStart);
        dest.writeString(morningStop);
        dest.writeString(nightStart);
        dest.writeString(nightStop);
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getTotalTime() {
        return totalTime;
    }
}
