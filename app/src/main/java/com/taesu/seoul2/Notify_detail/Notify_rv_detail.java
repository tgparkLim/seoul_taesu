package com.taesu.seoul2.Notify_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.taesu.seoul2.R;

/**
 * Created by uhees on 2017-10-09.
 */

public class Notify_rv_detail extends AppCompatActivity{

    TextView txt_notiTitle, txt_notiCategory, txt_notiDate, txt_notiContent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.notify_toolBar);

        txt_notiCategory = (TextView) findViewById(R.id.txt_notidetail_category);
        txt_notiTitle = (TextView) findViewById(R.id.txt_notidetail_title);
        txt_notiDate = (TextView) findViewById(R.id.txt_notidetail_date);
        txt_notiContent = (TextView) findViewById(R.id.txt_notidetail_content);

        //RECEIVE
        Intent i = this.getIntent();
        String notiCategory = i.getExtras().getString("notiCategory_KEY");
        String notiTitle = i.getExtras().getString("notiTitle_KEY");
        String notiDate = i.getExtras().getString("notiDate_KEY");
        String notiContent = i.getExtras().getString("notiContent_KEY");

        txt_notiTitle.setText(notiTitle);
        txt_notiCategory.setText(notiCategory);
        txt_notiDate.setText(notiDate);
        txt_notiContent.setText(notiContent);
    }
}
