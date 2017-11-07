package com.taesu.seoul2.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taesu.seoul2.MainActivity_detail.MainNearPlace_model;
import com.taesu.seoul2.MainActivity_detail.MainNearPlace_rv_detail;
import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

import java.util.ArrayList;

/**
 * Created by park on 2017-10-29.
 */

public class MyAdapterMainNearPlace
        extends RecyclerView.Adapter<MyHolderMainNearPlace> {

    Context c;
    public static ArrayList<MainNearPlace_model> mainNearPlace_modelArrayList;

    public MyAdapterMainNearPlace(Context c
            , ArrayList<MainNearPlace_model> mainNearPlace_modelArrayList) {
        this.c = c;
        this.mainNearPlace_modelArrayList = mainNearPlace_modelArrayList;
    }

    @Override
    public MyHolderMainNearPlace onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_main_near_place, parent, false);
        MyHolderMainNearPlace myHolderMainNearPlace = new MyHolderMainNearPlace(v);

        return myHolderMainNearPlace;

    }

    @Override
    public void onBindViewHolder(MyHolderMainNearPlace holder, int position) {

        final MainNearPlace_model mainNearPlaceModel
                = mainNearPlace_modelArrayList.get(position);

        holder.nameTxtMNP.setText(mainNearPlaceModel.getNameMNP());
        holder.categoryTxtMNP.setText(mainNearPlaceModel.getCategoryMNP());
        holder.addressTxtMNP.setText(mainNearPlaceModel.getAddressMNP());
        holder.phoneTxtMNP.setText(mainNearPlaceModel.getPhoneMNP());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                openDetailActivity_MNP(mainNearPlaceModel.getNameMNP()
                        ,mainNearPlaceModel.getCategoryMNP()
                        ,mainNearPlaceModel.getPhoneMNP()
                        ,mainNearPlaceModel.getAddressMNP()
                        ,mainNearPlaceModel.getLinkMNP()
                        ,mainNearPlaceModel.getSizeMNP()
                        ,mainNearPlaceModel.getPeopleMNP()
                        ,mainNearPlaceModel.getPlaceimage1MNP()
                        ,mainNearPlaceModel.getPlaceimage2MNP()
                        ,mainNearPlaceModel.getPlaceimage3MNP());

            }
        });

    }

    @Override
    public int getItemCount() {
        return mainNearPlace_modelArrayList.size();
    }

    public void openDetailActivity_MNP(String name, String category, String phone, String address, String link, String size, String people, String image1, String image2, String image3) {

        Intent i = new Intent(c, MainNearPlace_rv_detail.class);

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
