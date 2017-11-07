package com.taesu.seoul2.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.Place_detail.Place3_model;
import com.taesu.seoul2.Place_detail.Tab2_rv_detail;
import com.taesu.seoul2.R;

import java.util.ArrayList;

/**
 * Created by park on 2017-10-19.
 */

public class MyAdapterPlace3 extends RecyclerView.Adapter<MyHolderPlace3> {

    Context c;
    ArrayList<Place3_model> names;

    public MyAdapterPlace3(Context c, ArrayList<Place3_model> names) {
        this.c = c;
        this.names = names;
    }

    @Override
    public MyHolderPlace3 onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_place3, parent, false);
        MyHolderPlace3 myHolderPlace3 = new MyHolderPlace3(v);

        return myHolderPlace3;
    }

    @Override
    public void onBindViewHolder(MyHolderPlace3 holder, int position) {

        final Place3_model p = names.get(position);

        holder.nameTxt3.setText(p.getName3());
        holder.categoryTxt3.setText(p.getCategory3());
        holder.addressTxt3.setText(p.getAddress3());
        holder.phoneTxt3.setText(p.getPhone3());

        //holder.

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                openDetailActivity(p.getName3(),p.getCategory3(),p.getPhone3(),p.getAddress3(),p.getLink3(),p.getSize3(),p.getPeople3());
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    private void openDetailActivity(String name, String category, String phone, String address, String link, String size, String people) {

        Intent i = new Intent(c, Tab2_rv_detail.class);

        //PACK DATA
        i.putExtra("NAME_KEY",name);
        i.putExtra("CATEGORY_KEY", category);
        i.putExtra("PHONE_KEY",phone);
        i.putExtra("ADDRESS_KEY",address);
        i.putExtra("LINK_KEY",link);
        i.putExtra("SIZE_KEY",size);
        i.putExtra("PEOPLE_KEY", people);
//        i.putExtra("IMAGE1_KEY", image1);
//        i.putExtra("IMAGE2_KEY", image2);
//        i.putExtra("IMAGE3_KEY", image3);

        c.startActivity(i);

    }
}