package com.taesu.seoul2.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

/**
 * Created by park on 2017-09-27.
 */

public class MyHolderFindCaregiver extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView titleTxtFind;
    TextView nicTxtFind;
    TextView dateTxtFind;
    TextView addressTxtFind;

    ItemClickListener itemClickListener;

    public MyHolderFindCaregiver(View itemView) {
        super(itemView);

        titleTxtFind = (TextView) itemView.findViewById(R.id.txt_fcTitle);
        nicTxtFind = (TextView) itemView.findViewById(R.id.txt_fcNic);
        dateTxtFind = (TextView) itemView.findViewById(R.id.txt_fcDate);
        addressTxtFind = (TextView) itemView.findViewById(R.id.txt_fcAddress);

        itemView.setOnClickListener(this);

    }

    //@Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick();
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }

}