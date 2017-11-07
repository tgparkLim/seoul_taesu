package com.taesu.seoul2.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taesu.seoul2.FindPatient_detail.Findpatient_detail;
import com.taesu.seoul2.FindPatient_detail.Findpatient_model;
import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

import java.util.ArrayList;

/**
 * Created by uhees on 2017-10-19.
 */

public class MyAdapterFindpatient extends RecyclerView.Adapter<MyHolderFindpatient>{

    Context c;
    ArrayList<Findpatient_model> ageP;

    public MyAdapterFindpatient(Context c, ArrayList<Findpatient_model> ageP) {
        this.c = c;
        this.ageP = ageP;
    }

    @Override
    public MyHolderFindpatient onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_findpatient, parent, false);
        MyHolderFindpatient MyHolderFindpatient = new MyHolderFindpatient(v);

        return MyHolderFindpatient;
    }

    @Override
    public void onBindViewHolder(MyHolderFindpatient holder, int position) {

        final Findpatient_model Pm = ageP.get(position);

        holder.titleTxtFind2.setText(Pm.getTitleP());
        holder.nicTxtFind2.setText(Pm.getNicP());
        holder.dateTxtFind2.setText(Pm.getDateP());
        holder.addressTxtFind2.setText(Pm.getHopelocationP());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                openDetailActivity(Pm.getTitleP(),Pm.getNicP(),Pm.getDateP(), Pm.getGenderP(),Pm.getAgeP(),Pm.getPhoneP(),Pm.getCertifyP(),Pm.getJobP(),Pm.getHopelocationP(),Pm.getHopecostP(),Pm.getStartdateP(),Pm.getHopegenderP(),Pm.getContentP());
            }
        });
    }

    @Override
    public int getItemCount() {
        return ageP.size();
    }

    private void openDetailActivity(String title, String nic, String date, String gender, String age, String phone, String certify, String job, String hopelocation, String hopecost, String startdate, String hopegender, String content) {

        Intent i = new Intent(c, Findpatient_detail.class);

        //PACK DATA
        i.putExtra("title_KEY",title);
        i.putExtra("nic_KEY",nic);
        i.putExtra("date_KEY",date);
        i.putExtra("patientGender_KEY",gender);
        i.putExtra("age_KEY",age);
        i.putExtra("phone_KEY",phone);
        i.putExtra("certify_KEY",certify);
        i.putExtra("job_KEY", job);
        i.putExtra("address_KEY", hopelocation);
        i.putExtra("cost_KEY",hopecost);
        i.putExtra("termstart_KEY",startdate);
//        i.putExtra("lastdate_KEY",lastdate);
        i.putExtra("hopeGender_KEY", hopegender);
        i.putExtra("content_KEY", content);


        c.startActivity(i);

    }
}
