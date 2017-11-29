package com.taesu.seoul2.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.Place_detail.Place2_model;
import com.taesu.seoul2.Place_detail.Tab2_rv_detail;
import com.taesu.seoul2.R;

import java.util.ArrayList;

/**
 * Created by park on 2017-10-18.
 */

public class MyAdapterPlace2 extends RecyclerView.Adapter<MyHolderPlace2> {

    Context c;
    ArrayList<Place2_model> names;

    public MyAdapterPlace2(Context c, ArrayList<Place2_model> names) {
        this.c = c;
        this.names = names;
    }

    @Override
    public MyHolderPlace2 onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_place2, parent, false);
        MyHolderPlace2 myHolderPlace2 = new MyHolderPlace2(v);

        return myHolderPlace2;
    }

    @Override
    public void onBindViewHolder(MyHolderPlace2 holder, int position) {

        final Place2_model p = names.get(position);

        holder.nameTxt2.setText(p.getName2());
        holder.categoryTxt2.setText(p.getCategory2());
        holder.addressTxt2.setText(p.getAddress2());
        holder.phoneTxt2.setText(p.getPhone2());


        //holder.

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                openDetailActivity(p.getName2(),p.getCategory2(),p.getPhone2()
                        ,p.getAddress2(),p.getLink2(),p.getSize2(),p.getPeople2()
                        ,p.getPlaceimage21(),p.getPlaceimage22(),p.getPlaceimage23());
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    private void openDetailActivity(String name, String category, String phone, String address, String link
            , String size, String people, String image1, String image2, String image3) {

        Intent i = new Intent(c, Tab2_rv_detail.class);

        //PACK DATA
        i.putExtra("NAME_KEY",name);
        i.putExtra("CATEGORY_KEY", category);
        i.putExtra("PHONE_KEY",phone);
        i.putExtra("ADDRESS_KEY",address);
        i.putExtra("LINK_KEY",link);
        i.putExtra("SIZE_KEY",size);
        i.putExtra("PEOPLE_KEY", people);
        i.putExtra("IMAGE1_KEY", image1);
        i.putExtra("IMAGE2_KEY", image2);
        i.putExtra("IMAGE3_KEY", image3);

        c.startActivity(i);

    }
}
