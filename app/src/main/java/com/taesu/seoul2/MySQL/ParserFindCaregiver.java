package com.taesu.seoul2.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.taesu.seoul2.FindCaregiver_detail.FindCaregiver_model;
import com.taesu.seoul2.Recycler.MyAdapterFindCaregiver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by park on 2017-09-29.
 */

public class ParserFindCaregiver extends AsyncTask<Void, Void, Integer> {

    String data;
    RecyclerView rv;
    Context c;
    ArrayList<FindCaregiver_model> agesF = new ArrayList<>();

    public ParserFindCaregiver(Context c, String data, RecyclerView rv) {
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

            MyAdapterFindCaregiver adapterFindCaregiver = new MyAdapterFindCaregiver(c, agesF);
            rv.setAdapter(adapterFindCaregiver);

        } else {

            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();

        }

    }


    private int parse() {

        try {

            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            agesF.clear();
            FindCaregiver_model findCaregiver_model;

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
                String patientGender=
                        jo.getString("patientGender");
                String ages=
                        jo.getString("ages");
                String desiredCareSex=
                        jo.getString("desiredCareSex");
                String patientsSymptoms=
                        jo.getString("patientsSymptoms");
                String address=
                        jo.getString("address");
                String contactNumber=
                        jo.getString("contactNumber");
                String cost=
                        jo.getString("cost");
                String termstart=
                        jo.getString("termstart");
                String requirementsWord=
                        jo.getString("requirementsWord");


                findCaregiver_model = new FindCaregiver_model();

                findCaregiver_model.setIdF(id);
                findCaregiver_model.setTitleF(title);
                findCaregiver_model.setNicF(nic);
                findCaregiver_model.setDateF(date);
                findCaregiver_model.setPatientGenderF(patientGender);
                findCaregiver_model.setAgesF(ages);
                //findCaregiver_model.setAgesF(address);
                findCaregiver_model.setDesiredCareSexF(desiredCareSex);
                findCaregiver_model.setPatientsSymptomsF(patientsSymptoms);
                findCaregiver_model.setAddressF(address);
                findCaregiver_model.setContactNumberF(contactNumber);
                findCaregiver_model.setCostF(cost);
                findCaregiver_model.setTermstartF(termstart);
                findCaregiver_model.setRequirementsWordF(requirementsWord);

                agesF.add(findCaregiver_model);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;

    }
}