package com.taesu.seoul2.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.taesu.seoul2.Place_detail.Place1_model;
import com.taesu.seoul2.Place_detail.Place2_model;
import com.taesu.seoul2.Recycler.MyAdapterPlace;
import com.taesu.seoul2.Recycler.MyAdapterPlace2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by park on 2017-10-18.
 */

public class ParserPlace2 extends AsyncTask<Void, Void, Integer> {

    String data;
    RecyclerView rv;
    Context c;
    ArrayList<Place2_model> addresses2 = new ArrayList<>();

    public ParserPlace2(Context c, String data, RecyclerView rv) {
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

            MyAdapterPlace2 adapterPlace2 = new MyAdapterPlace2(c, addresses2);
            rv.setAdapter(adapterPlace2);

        } else {

            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();

        }

    }


    private int parse() {

        try {

            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            addresses2.clear();
            Place2_model place2_model;

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
//                String image1 = jo.getString("image1");
//                String image2 = jo.getString("image2");
//                String image3 = jo.getString("image3");

                place2_model = new Place2_model();

                place2_model.setId2(id);
                place2_model.setName2(name);
                place2_model.setCategory2(category);
                place2_model.setAddress2(address);
                place2_model.setPhone2(phone);
                place2_model.setLink2(link);
                place2_model.setSize2(size);
                place2_model.setPeople2(people);
//                place1_model.setPlaceimage1(image1);
//                place1_model.setPlaceimage2(image2);
//                place1_model.setPlaceimage3(image3);

                addresses2.add(place2_model);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;

    }
}
