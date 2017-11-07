package com.taesu.seoul2.FindCaregiver_detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.taesu.seoul2.R;

/**
 * Created by park on 2017-09-29.
 */

public class FindCaregiver_rv_detail extends AppCompatActivity {

    private TextView titleTxt, nicTxt, dateTxt, patientGenderTxt, agesTxt, desiredCareSexTxt,
            patientsSymptomsTxt, addressTxt, contactNumberTxt, costTxt, termstartTxt, requirementsWordTxt;

    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findcaregiver_rv_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.findcaregiver_detail_toolBar);

        titleTxt = (TextView) findViewById(R.id.txt_findtitle1);
        nicTxt = (TextView) findViewById(R.id.txt_findnic1);
        dateTxt = (TextView) findViewById(R.id.txt_finddate1);
        patientGenderTxt = (TextView) findViewById(R.id.txt_findgender1);
        agesTxt = (TextView) findViewById(R.id.txt_findage1);
        desiredCareSexTxt = (TextView) findViewById(R.id.txt_finddesire1);
        patientsSymptomsTxt = (TextView) findViewById(R.id.txt_findsick1);
        addressTxt = (TextView) findViewById(R.id.txt_findaddress1);
        contactNumberTxt = (TextView) findViewById(R.id.txt_findphone1);
        costTxt = (TextView)findViewById(R.id.txt_findcost1);
        termstartTxt =(TextView)findViewById(R.id.txt_findstart1);
        requirementsWordTxt = (TextView) findViewById(R.id.txt_findcontent1);

        btn_back = (Button)findViewById(R.id.btn_placeback);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //RECEIVE
        Intent i = this.getIntent();


        String title = i.getExtras().getString("title_KEY");
        String nic = i.getExtras().getString("nic_KEY");
        String date = i.getExtras().getString("date_KEY");
        String patientGender = i.getExtras().getString("patientGender_KEY");
        String ages = i.getExtras().getString("ages_KEY");
        String desiredCareSex = i.getExtras().getString("desiredCareSex_KEY");
        String patientsSymptoms = i.getExtras().getString("patientsSymptoms_KEY");
        String address = i.getExtras().getString("address_KEY");
        String contactNumber = i.getExtras().getString("contactNumber_KEY");
        String cost = i.getExtras().getString("cost_KEY");
        String termstart = i.getExtras().getString("termstart_KEY");
        String requirementsWord = i.getExtras().getString("requirementsWord_KEY");

        titleTxt.setText(title);
        nicTxt.setText(nic);
        dateTxt.setText(date);
        patientGenderTxt.setText(patientGender);
        agesTxt.setText(ages);
        desiredCareSexTxt.setText(desiredCareSex);
        patientsSymptomsTxt.setText(patientsSymptoms);
        addressTxt.setText(address);
        contactNumberTxt.setText(Html.fromHtml("<u>"+contactNumber+"</u>"));
        costTxt.setText(cost);
        termstartTxt.setText(termstart);
        requirementsWordTxt.setText(requirementsWord);

        //전화걸기
        contactNumberTxt.setOnClickListener(mClickListener);
//        SpannableString content = new SpannableString();
//        content.setSpan(new UnderlineSpan(), 0, content.length(),0);
//        phoneTxt1.setText(content);
    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+costTxt.getText().toString()));
            startActivity(intent);
        }
    };
}
