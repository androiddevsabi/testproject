package com.example.sabinajoshi.loadsheddingroutine;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sabina joshi on 20/04/2016.
 */
public class CustomAdapter extends ArrayAdapter{
    Context context;
    ArrayList<Schedule> data;
    Schedule obj;
    public CustomAdapter(Context context, ArrayList<Schedule> objt) {
        super(context,R.layout.listitem,objt);
        this.context = context;
        this.data = objt;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
        TextView morningstart = (TextView) v.findViewById(R.id.morningstart);
        TextView morningstop = (TextView) v.findViewById(R.id.morningstop);
        TextView eveningstart = (TextView) v.findViewById(R.id.eveningstart);
        TextView eveningstop = (TextView) v.findViewById(R.id.eveningstop);
        TextView week = (TextView) v.findViewById(R.id.week);
        TextView time = (TextView) v.findViewById(R.id.time);
         obj = data.get(position);
        String WEEK= obj.getWeek();

        String MorningStart = obj.getMorningStart();
        Log.d("the mornining is",MorningStart);
        String MorningStop = obj.getMorningStop();
        String Time = obj.getTotalTime();
        morningstart.setText(MorningStart);
        morningstop.setText(MorningStop);
        eveningstart.setText(obj.getNightStart());
        eveningstop.setText(obj.getNightStop());
        time.setText(Time);
        week.setText(WEEK);






        return v;
    }
}
