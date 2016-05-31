package com.example.sabinajoshi.loadsheddingroutine;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    SlidingTabLayout tabs;
    ViewPagerAdapter adapter;
    public ArrayList<Schedule> scheduleArrayList;
    public HashMap<Integer,ArrayList<Schedule>> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColors);
            }

            @Override
            public int getDividerColor(int i) {
                return 0;
            }
        });

        pager = (ViewPager) findViewById(R.id.pager);
        String url = "http://loadsheddingalways.comli.com/tests.php";
        new GetData().execute(url);



    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        int numberoftabs;
        String[] heading;
        HashMap<Integer,ArrayList<Schedule>> map;


        public ViewPagerAdapter(FragmentManager fm, int NUMberofTabs, HashMap<Integer, ArrayList<Schedule>> names, String[] heading) {
            super(fm);
            this.numberoftabs = NUMberofTabs;
            this.heading = heading;
            this.map = names;
        }

        @Override
        public Fragment getItem(int position) {
            Tab1 tab1 = new Tab1();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("all",map.get(position));
            tab1.setArguments(bundle);
            return tab1;
        }

        @Override
        public int getCount() {
            return numberoftabs;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return heading[position];
        }
    }
    private class GetData extends AsyncTask<String,String,String> {
        int NumbeofTabs =7;
        Schedule schedule;
        String[] heading={"1","2","3","4","5","6","7"};

        @Override
        protected String doInBackground(String... params) {
            Download util = new Download(params[0]);
            return util.getJson();
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("the result is", s);
            try {
                JSONObject object = new JSONObject(s);
                JSONArray data = object.getJSONArray("data");
                map = new HashMap<>();
                for (int i = 0;i<data.length();i++){
                    JSONArray array = data.getJSONArray(i);
                    scheduleArrayList = new ArrayList<>();
                    for (int j=0;j<array.length();j++)
                    {
                        schedule = new Schedule();
                        JSONObject list = array.getJSONObject(j);
                        schedule.setWeek(list.getString("Week"));
                        schedule.setMorningStart(list.getString("MorningStart"));
                        schedule.setMorningStop(list.getString("MorningStop"));
                        schedule.setNightStart(list.getString("NightStart"));
                        schedule.setNightStop(list.getString("NightStop"));
                        schedule.setTotalTime(list.getString("TotalTime"));

                        scheduleArrayList.add(schedule);
                    }
                    map.put(i,scheduleArrayList);


                }
                adapter= new ViewPagerAdapter(getSupportFragmentManager(),NumbeofTabs,map,heading);
                pager.setAdapter(adapter);
                tabs.setViewPager(pager);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
