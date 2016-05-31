package com.example.sabinajoshi.loadsheddingroutine;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sabina joshi on 19/04/2016.
 */
public class Download {
    String link;
    public Download(String param) {
        this.link = param;

    }

    public String getJson() {
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            while((line = reader.readLine())!= null){
                builder.append(line);

            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
