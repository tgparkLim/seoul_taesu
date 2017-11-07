package com.taesu.seoul2.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.taesu.seoul2.Place_detail.ItemClickListener;
import com.taesu.seoul2.R;

/**
 * Created by park on 2017-10-29.
 */

public class MyHolderMainNearPlace extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nameTxtMNP, categoryTxtMNP, addressTxtMNP, phoneTxtMNP;

    ItemClickListener itemClickListener;

    public MyHolderMainNearPlace(View itemView) {
        super(itemView);

        nameTxtMNP = (TextView) itemView.findViewById(R.id.txt_plNameMNR);
        categoryTxtMNP = (TextView) itemView.findViewById(R.id.txt_plCategoryMNR);
        addressTxtMNP = (TextView) itemView.findViewById(R.id.txt_plAddressMNR);
        phoneTxtMNP = (TextView) itemView.findViewById(R.id.txt_plPhoneMNR);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
