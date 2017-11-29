package com.taesu.seoul2.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.taesu.seoul2.Place_detail.Place2_model;
import com.taesu.seoul2.Place_detail.Place3_model;
import com.taesu.seoul2.Recycler.MyAdapterPlace2;
import com.taesu.seoul2.Recycler.MyAdapterPlace3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by park on 2017-10-19.
 */

public class ParserPlace3 extends AsyncTask<Void, Void, Integer> {

    String data;
    RecyclerView rv;
    Context c;
    ArrayList<Place3_model> addresses3 = new ArrayList<>();

    public ParserPlace3(Context c, String data, RecyclerView rv) {
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

            MyAdapterPlace3 adapterPlace3 = new MyAdapterPlace3(c, addresses3);
            rv.setAdapter(adapterPlace3);

        } else {

            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();

        }

    }


    private int parse() {

        try {

            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            addresses3.clear();
            Place3_model place3_model;

            for(int i = 0; i < ja.length(); i++) {

                jo = ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("name");
                String category=jo.getString("category");
                String address=jo.getString("address");
                String phone=jo.getString("phone");
                String link=jo.getString("link");
                String size=jo.getString("size");
                String people=jo.getString("people");
                String image1 = jo.getString("image1");
                String image2 = jo.getString("image2");
                String image3 = jo.getString("image3");

                place3_model = new Place3_model();

                place3_model.setId3(id);
                place3_model.setName3(name);
                place3_model.setCategory3(category);
                place3_model.setAddress3(address);
                place3_model.setPhone3(phone);
                place3_model.setLink3(link);
                place3_model.setSize3(size);
                place3_model.setPeople3(people);
                place3_model.setPlaceimage31(image1);
                place3_model.setPlaceimage32(image2);
                place3_model.setPlaceimage33(image3);

                addresses3.add(place3_model);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;

    }
}
