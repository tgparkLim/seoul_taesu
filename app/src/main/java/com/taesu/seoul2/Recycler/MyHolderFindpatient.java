package com.taesu.seoul2.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

/**
 * Created by uhees on 2017-10-19.
 */

public class MyHolderFindpatient extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView titleTxtFind2;
    TextView nicTxtFind2;
    TextView dateTxtFind2;
    TextView addressTxtFind2;

    ItemClickListener itemClickListener;

    public MyHolderFindpatient(View itemView) {
        super(itemView);

        titleTxtFind2 = (TextView)itemView.findViewById(R.id.txt_fpTitle);
        nicTxtFind2 = (TextView) itemView.findViewById(R.id.txt_fpNic);
        dateTxtFind2 = (TextView) itemView.findViewById(R.id.txt_fpDate);
        addressTxtFind2 = (TextView) itemView.findViewById(R.id.txt_fpAddress);

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