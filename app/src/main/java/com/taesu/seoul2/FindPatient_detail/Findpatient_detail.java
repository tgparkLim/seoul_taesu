package com.taesu.seoul2.FindPatient_detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.taesu.seoul2.R;

public class Findpatient_detail extends AppCompatActivity {

    private TextView titleTxt2, nicTxt2, dateTxt2, genderTxt2, ageTxt2, phoneTxt2, certifyTxt2,jobTxt2,
            addressTxt2, costTxt2, startdateTxt2,hopegenderTxt2, contentTxt2;
    Button btn_patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpatient_detail);

        titleTxt2 = (TextView) findViewById(R.id.txt_findtitle2);
        nicTxt2 = (TextView) findViewById(R.id.txt_findnic2);
        dateTxt2 = (TextView) findViewById(R.id.txt_finddate2);
        genderTxt2 = (TextView) findViewById(R.id.txt_findgender2);
        ageTxt2 = (TextView) findViewById(R.id.txt_findage2);
        phoneTxt2 = (TextView) findViewById(R.id.txt_findphone2);
        certifyTxt2 = (TextView) findViewById(R.id.txt_findcertify2);
        jobTxt2 = (TextView) findViewById(R.id.txt_findjob2);
        addressTxt2 = (TextView) findViewById(R.id.txt_findaddress2);
        costTxt2 = (TextView) findViewById(R.id.txt_findcost2);
        startdateTxt2 = (TextView)findViewById(R.id.txt_findstart2);
        hopegenderTxt2 = (TextView)findViewById(R.id.txt_finddesire2);
        contentTxt2 = (TextView) findViewById(R.id.txt_findcontent2);


        btn_patient = (Button)findViewById(R.id.btn_findPatient);
        btn_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //RECEIVE
        Intent i = this.getIntent();


        String title2 = i.getExtras().getString("title_KEY");
        String nic2 = i.getExtras().getString("nic_KEY");
        String date2 = i.getExtras().getString("date_KEY");
        String gender2 = i.getExtras().getString("patientGender_KEY");
        String age2 = i.getExtras().getString("age_KEY");
        String phone2 = i.getExtras().getString("phone_KEY");
        String certify2 = i.getExtras().getString("certify_KEY");
        String job2 = i.getExtras().getString("job_KEY");
        String address2 = i.getExtras().getString("address_KEY");
        String cost2 = i.getExtras().getString("cost_KEY");
        String termstart2 = i.getExtras().getString("termstart_KEY");
        String hopegender2 = i.getExtras().getString("hopeGender_KEY");
        String content2 = i.getExtras().getString("content_KEY");

        titleTxt2.setText(title2);
        nicTxt2.setText(nic2);
        dateTxt2.setText(date2);
        genderTxt2.setText(gender2);
        ageTxt2.setText(age2);
        phoneTxt2.setText(Html.fromHtml("<u>"+phone2+"</u>"));
        certifyTxt2.setText(certify2);
        addressTxt2.setText(address2);
        jobTxt2.setText(job2);
        costTxt2.setText(cost2);
        startdateTxt2.setText(termstart2);
        hopegenderTxt2.setText(hopegender2);
        contentTxt2.setText(content2);

        //전화걸기
        phoneTxt2.setOnClickListener(mClickListener);
//        SpannableString content = new SpannableString();
//        content.setSpan(new UnderlineSpan(), 0, content.length(),0);
//        phoneTxt1.setText(content);
    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneTxt2.getText().toString()));
            startActivity(intent);
        }
    };
}


