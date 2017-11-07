package com.taesu.seoul2.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taesu.seoul2.FindCaregiver_detail.FindCaregiver_model;
import com.taesu.seoul2.FindCaregiver_detail.FindCaregiver_rv_detail;
import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

import java.util.ArrayList;

/**
 * Created by park on 2017-09-27.
 */

public class MyAdapterFindCaregiver extends RecyclerView.Adapter<MyHolderFindCaregiver> {

    Context c;
    ArrayList<FindCaregiver_model> agesF;

    public MyAdapterFindCaregiver(Context c, ArrayList<FindCaregiver_model> agesF) {
        this.c = c;
        this.agesF = agesF;
    }

    @Override
    public MyHolderFindCaregiver onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_findcaregiver, parent, false);
        MyHolderFindCaregiver MyHolderFindcaregiver = new MyHolderFindCaregiver(v);

        return MyHolderFindcaregiver;
    }

    @Override
    public void onBindViewHolder(MyHolderFindCaregiver holder, int position) {

        final FindCaregiver_model Fm = agesF.get(position);

        holder.titleTxtFind.setText(Fm.getTitleF());
        holder.nicTxtFind.setText(Fm.getNicF());
        holder.dateTxtFind.setText(Fm.getDateF());
        holder.addressTxtFind.setText(Fm.getAddressF());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                openDetailActivity(Fm.getTitleF(),Fm.getNicF(),Fm.getDateF(), Fm.getPatientGenderF(),Fm.getAgesF(),Fm.getDesiredCareSexF(),Fm.getPatientsSymptomsF(),Fm.getAddressF(),Fm.getContactNumberF(),Fm.getCostF(),Fm.getTermstartF(),Fm.getRequirementsWordF());
            }
        });

    }

    @Override
    public int getItemCount() {
        return agesF.size();
    }

    private void openDetailActivity(String title, String nic, String date, String patientGender, String ages, String desiredCareSex, String patientsSymptoms, String address, String contactNumber, String cost, String termstart, String requirementsWord) {

        Intent i = new Intent(c, FindCaregiver_rv_detail.class);

        //PACK DATA
        i.putExtra("title_KEY",title);
        i.putExtra("nic_KEY",nic);
        i.putExtra("date_KEY",date);
        i.putExtra("patientGender_KEY",patientGender);
        i.putExtra("ages_KEY",ages);
        i.putExtra("desiredCareSex_KEY",desiredCareSex);
        i.putExtra("patientsSymptoms_KEY",patientsSymptoms);
        i.putExtra("address_KEY", address);
        i.putExtra("contactNumber_KEY", contactNumber);
        i.putExtra("cost_KEY",cost);
        i.putExtra("termstart_KEY",termstart);
        i.putExtra("requirementsWord_KEY", requirementsWord);


        c.startActivity(i);

    }
}
