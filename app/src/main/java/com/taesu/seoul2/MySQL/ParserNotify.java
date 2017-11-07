package com.taesu.seoul2.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.taesu.seoul2.Notify_detail.Notify_model;
import com.taesu.seoul2.Recycler.MyAdapterNotify;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by uhees on 2017-10-10.
 */

public class ParserNotify extends AsyncTask<Void, Void, Integer> {

    String data;
    RecyclerView rv;
    Context c;
    ArrayList<Notify_model> titles = new ArrayList<>();

    public ParserNotify(Context c, String data, RecyclerView rv){
        this.c = c;
        this.data = data;
        this.rv = rv;
    }
    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        if(integer == 1) {

            MyAdapterNotify adapterPlaceN = new MyAdapterNotify(c, titles);
            rv.setAdapter(adapterPlaceN);

        } else {

            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();

        }

    }

    private int parse() {

        try {

            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            titles.clear();
            Notify_model notify_model;

            for(int i = 0; i < ja.length(); i++) {

                jo = ja.getJSONObject(i);

                int id=jo.getInt("id");
                String category=jo.getString("category");
                String title=jo.getString("title");
                String date=jo.getString("date");
                String content=jo.getString("content");

                notify_model = new Notify_model();

                notify_model.setIdN(id);
                notify_model.setCategory(category);
                notify_model.setTitle(title);
                notify_model.setDate(date);
                notify_model.setContent(content);

                titles.add(notify_model);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;

    }
}
