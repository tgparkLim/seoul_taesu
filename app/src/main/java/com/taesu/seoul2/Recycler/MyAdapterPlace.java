package com.taesu.seoul2.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taesu.seoul2.MainActivity_detail.ViewPagerAdapter;
import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.Place_detail.Place1_model;
import com.taesu.seoul2.Place_detail.Tab1_rv_detail;
import com.taesu.seoul2.Place_detail.ViewPagerAdapterPlace1;
import com.taesu.seoul2.R;

import java.util.ArrayList;

/**
 * Created by park on 2017-09-08.
 */

public class MyAdapterPlace extends RecyclerView.Adapter<MyHolderPlace> {

    Context c;
    ArrayList<Place1_model> names;

    public MyAdapterPlace(Context c, ArrayList<Place1_model> names) {
        this.c = c;
        this.names = names;
    }

    @Override
    public MyHolderPlace onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_place1, parent, false);
        MyHolderPlace myHolderPlace = new MyHolderPlace(v);

        return myHolderPlace;
    }

    @Override
    public void onBindViewHolder(MyHolderPlace holder, int position) {

        final Place1_model p = names.get(position);

        holder.nameTxt1.setText(p.getName1());
        holder.categoryTxt1.setText(p.getCategory1());
        holder.addressTxt1.setText(p.getAddress1());
        holder.phoneTxt1.setText(p.getPhone1());

        //holder.

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                openDetailActivity(p.getName1(),p.getCategory1(),p.getPhone1()
                        ,p.getAddress1(),p.getLink1(),p.getSize1(),p.getPeople1()
                        ,p.getPlaceimage1(),p.getPlaceimage2(),p.getPlaceimage3());
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    private void openDetailActivity(String name, String category, String phone, String address, String link, String size, String people, String image1, String image2, String image3) {

        Intent i = new Intent(c, Tab1_rv_detail.class);

        //PACK DATA
        i.putExtra("NAME_KEY",name);
        i.putExtra("CATEGORY_KEY", category);
        i.putExtra("PHONE_KEY",phone);
        i.putExtra("ADDRESS_KEY",address);
        i.putExtra("LINK_KEY",link);
        i.putExtra("SIZE_KEY",size);
        i.putExtra("PEOPLE_KEY", people);

        //Intent im = new Intent(c, ViewPagerAdapterPlace1.class);

        i.putExtra("IMAGE1_KEY", image1);
        i.putExtra("IMAGE2_KEY", image2);
        i.putExtra("IMAGE3_KEY", image3);

//        im.putExtra("IMAGE1_KEY", image1);
//        im.putExtra("IMAGE2_KEY", image2);
//        im.putExtra("IMAGE3_KEY", image3);
//
//        c.startActivity(im);

        c.startActivity(i);

    }
}
