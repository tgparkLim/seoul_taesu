package com.taesu.seoul2.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

/**
 * Created by uhees on 2017-10-09.
 */

public class MyHolderNotify extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView CategoryTxt, TitleTxt, DateTxt;
    ItemClickListener itemClickListener;

    public MyHolderNotify(View itemView) {
        super(itemView);

        CategoryTxt = (TextView) itemView.findViewById(R.id.txt_noticategory);
        TitleTxt = (TextView) itemView.findViewById(R.id.txt_notititle);
        DateTxt = (TextView) itemView.findViewById(R.id.txt_notidate);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick();
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
}
