package com.taesu.seoul2.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.taesu.seoul2.Place_detail.Place1_model;
import com.taesu.seoul2.Recycler.MyAdapterPlace;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by park on 2017-09-08.
 */

public class ParserPlace extends AsyncTask<Void, Void, Integer> {

    String data;
    RecyclerView rv;
    Context c;
    ArrayList<Place1_model> addresses = new ArrayList<>();

    public ParserPlace(Context c, String data, RecyclerView rv) {
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

            MyAdapterPlace adapterPlace1 = new MyAdapterPlace(c, addresses);
            rv.setAdapter(adapterPlace1);

        } else {

            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();

        }

    }


    private int parse() {

        try {

            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            addresses.clear();
            Place1_model place1_model;

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

                place1_model = new Place1_model();

                place1_model.setId1(id);
                place1_model.setName1(name);
                place1_model.setCategory1(category);
                place1_model.setAddress1(address);
                place1_model.setPhone1(phone);
                place1_model.setLink1(link);
                place1_model.setSize1(size);
                place1_model.setPeople1(people);
                place1_model.setPlaceimage1(image1);
                place1_model.setPlaceimage2(image2);
                place1_model.setPlaceimage3(image3);

                addresses.add(place1_model);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;

    }
}
