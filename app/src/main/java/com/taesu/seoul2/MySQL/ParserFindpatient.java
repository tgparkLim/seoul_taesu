package com.taesu.seoul2.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.taesu.seoul2.FindPatient_detail.Findpatient_model;
import com.taesu.seoul2.Recycler.MyAdapterFindpatient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by uhees on 2017-10-19.
 */

public class ParserFindpatient extends AsyncTask<Void, Void, Integer> {

    String data;
    RecyclerView rv;
    Context c;
    ArrayList<Findpatient_model> ageP = new ArrayList<>();

    public ParserFindpatient(Context c, String data, RecyclerView rv) {
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

            MyAdapterFindpatient adapterFindpatient = new MyAdapterFindpatient(c, ageP);
            rv.setAdapter(adapterFindpatient);

        } else {

            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();

        }

    }


    private int parse() {

        try {

            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            ageP.clear();
            Findpatient_model findpatient_model;

            for(int i = 0; i < ja.length(); i++) {

                jo = ja.getJSONObject(i);

                int id=
                        jo.getInt("id");
                String title=
                        jo.getString("title");
                String nic=
                        jo.getString("nic");
                String date=
                        jo.getString("date");
                String gender=
                        jo.getString("gender");
                String age=
                        jo.getString("age");
                String phone=
                        jo.getString("phone");
                String certify=
                        jo.getString("certify");
                String job=
                        jo.getString("job");
                String hopelocation=
                        jo.getString("hopelocation");
                String hopecost=
                        jo.getString("hopecost");
                String startdate=
                        jo.getString("startdate");
//                String lastdate=
//                        jo.getString("lastdate");
                String hopegender=
                        jo.getString("hopegender");
                String content=
                        jo.getString("content");


                findpatient_model = new Findpatient_model();

                findpatient_model.setIdP(id);
                findpatient_model.setTitleP(title);
                findpatient_model.setNicP(nic);
                findpatient_model.setDateP(date);
                findpatient_model.setGenderP(gender);
                findpatient_model.setAgeP(age);
                findpatient_model.setPhoneP(phone);
                findpatient_model.setCertifyP(certify);
                findpatient_model.setJobP(job);
                findpatient_model.setHopelocationP(hopelocation);
                findpatient_model.setHopecostP(hopecost);
                findpatient_model.setStartdateP(startdate);
//                findpatient_model.setLastdateP(lastdate);
                findpatient_model.setGenderP(hopegender);
                findpatient_model.setContentP(content);

                ageP.add(findpatient_model);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;

    }
}