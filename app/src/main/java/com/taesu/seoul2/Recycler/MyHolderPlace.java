package com.taesu.seoul2.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

/**
 * Created by park on 2017-09-08.
 */

public class MyHolderPlace extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView nameTxt1, categoryTxt1, addressTxt1, phoneTxt1;

    ItemClickListener itemClickListener;

    //public

    public MyHolderPlace(View itemView) {
        super(itemView);

        nameTxt1 = (TextView) itemView.findViewById(R.id.txt_plName1);
        categoryTxt1 = (TextView) itemView.findViewById(R.id.txt_plCategory1);
        addressTxt1 = (TextView) itemView.findViewById(R.id.txt_plAddress1);
        phoneTxt1 = (TextView) itemView.findViewById(R.id.txt_plPhone1);

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
