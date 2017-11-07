package com.taesu.seoul2.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.taesu.seoul2.MainActivity_detail.MainNearPlace_model;
import com.taesu.seoul2.Recycler.MyAdapterMainNearPlace;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by park on 2017-10-29.
 */

public class ParseMainNearPlace extends AsyncTask<Void, Void, Integer> {

    String data;
    RecyclerView rv;
    Context c;
    ArrayList<MainNearPlace_model> mainNearPlaceModelArrayList =
            new ArrayList<>();

    public ParseMainNearPlace(Context c, String data, RecyclerView rv) {

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

        if (integer == 1) {

            MyAdapterMainNearPlace myAdapterMainNearPlace
                    = new MyAdapterMainNearPlace(c, mainNearPlaceModelArrayList);
            rv.setAdapter(myAdapterMainNearPlace);

        } else {

            Toast.makeText(c, "unable to parse", Toast.LENGTH_SHORT).show();

        }

    }

    private int parse() {

        try {

            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            mainNearPlaceModelArrayList.clear();
            MainNearPlace_model mainNearPlace_model;

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
                String latitude = jo.getString("latitude");
                String longitude = jo.getString("longitude");

                mainNearPlace_model = new MainNearPlace_model();

                mainNearPlace_model.setIdMNP(id);
                mainNearPlace_model.setNameMNP(name);
                mainNearPlace_model.setCategoryMNP(category);
                mainNearPlace_model.setAddressMNP(address);
                mainNearPlace_model.setPhoneMNP(phone);
                mainNearPlace_model.setLinkMNP(link);
                mainNearPlace_model.setSizeMNP(size);
                mainNearPlace_model.setPeopleMNP(people);
                mainNearPlace_model.setPlaceimage1MNP(image1);
                mainNearPlace_model.setPlaceimage2MNP(image2);
                mainNearPlace_model.setPlaceimage3MNP(image3);
                mainNearPlace_model.setLatitudeMNP(latitude);
                mainNearPlace_model.setLongitudeMNP(longitude);

                mainNearPlaceModelArrayList.add(mainNearPlace_model);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;

    }

}
