package com.taesu.seoul2.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taesu.seoul2.Notify_detail.Notify_model;
import com.taesu.seoul2.Notify_detail.Notify_rv_detail;
import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

import java.util.ArrayList;

/**
 * Created by uhees on 2017-10-09.
 */

public class MyAdapterNotify extends RecyclerView.Adapter<MyHolderNotify> {

    Context c;
    ArrayList<Notify_model> titles;

    public MyAdapterNotify(Context c, ArrayList<Notify_model> titles){
        this.c = c;
        this.titles = titles;
    }

    @Override
    public MyHolderNotify onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_notice, parent, false);
        MyHolderNotify myHolderNotify = new MyHolderNotify(v);

        return myHolderNotify;
    }

    @Override
    public void onBindViewHolder(MyHolderNotify holder, int position) {
        final Notify_model n = titles.get(position);

        holder.CategoryTxt.setText(n.getCategory());
        holder.TitleTxt.setText(n.getTitle());
        holder.DateTxt.setText(n.getDate());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                openDetailActivity(n.getCategory(),n.getTitle(),n.getDate(),n.getContent());
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    private void openDetailActivity(String category, String title, String date, String content) {

        Intent i = new Intent(c, Notify_rv_detail.class);

        //PACK DATA
        i.putExtra("notiCategory_KEY",category);
        i.putExtra("notiTitle_KEY",title);
        i.putExtra("notiDate_KEY",date);
        i.putExtra("notiContent_KEY", content);

        c.startActivity(i);

    }
}
