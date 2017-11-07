package com.taesu.seoul2.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

/**
 * Created by park on 2017-10-18.
 */

public class MyHolderPlace2 extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView nameTxt2, categoryTxt2, addressTxt2, phoneTxt2;

    ItemClickListener itemClickListener;

    //public

    public MyHolderPlace2(View itemView) {
        super(itemView);

        nameTxt2 = (TextView) itemView.findViewById(R.id.txt_plName2);
        categoryTxt2 = (TextView) itemView.findViewById(R.id.txt_plCategory2);
        addressTxt2 = (TextView) itemView.findViewById(R.id.txt_plAddress2);
        phoneTxt2 = (TextView) itemView.findViewById(R.id.txt_plPhone2);


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

