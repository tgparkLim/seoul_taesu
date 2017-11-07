package com.taesu.seoul2.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

/**
 * Created by park on 2017-10-19.
 */
public class MyHolderPlace3 extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView nameTxt3, categoryTxt3, addressTxt3, phoneTxt3;

    ItemClickListener itemClickListener;

    //public

    public MyHolderPlace3(View itemView) {
        super(itemView);

        nameTxt3 = (TextView) itemView.findViewById(R.id.txt_plName3);
        categoryTxt3 = (TextView) itemView.findViewById(R.id.txt_plCategory3);
        addressTxt3 = (TextView) itemView.findViewById(R.id.txt_plAddress3);
        phoneTxt3 = (TextView) itemView.findViewById(R.id.txt_plPhone3);

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

