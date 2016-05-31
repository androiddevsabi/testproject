package com.example.sabinajoshi.loadsheddingroutine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sabina joshi on 18/04/2016.
 */
public class Tab1 extends Fragment {
    Bundle bundle = null;
    int posi;
    ArrayList<Schedule> data;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bundle = getArguments();
        data = bundle.getParcelableArrayList("all");
        View v = inflater.inflate(R.layout.tab1,container,false);
        ListView lv = (ListView) v.findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(getContext(),data);
        lv.setAdapter(adapter);
        return v;
    }
}
