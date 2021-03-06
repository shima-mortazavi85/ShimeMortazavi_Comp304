package com.example.shime_mortazavi_comp304;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask {

   String data;
    int myArray [] = new int[12];

            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    URL url=new URL("https://api.jsonbin.io/b/60431954121bf907dd971274");
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    InputStream inputStream=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                    String line="";
                    while (line != null)
                     {

                        line=bufferedReader.readLine();
                        data=data+line;
                    }
                    JSONArray Gold=new JSONArray(data);
                    for(int i=0;i<Gold.length();i++){
                       myArray[i] = Integer.parseInt((String) Gold.get(i));
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }


    @Override
    protected void onPostExecute(Object o)
    {
        super.onPostExecute(o);
        Second.data.setText(this.data);
    }
}
