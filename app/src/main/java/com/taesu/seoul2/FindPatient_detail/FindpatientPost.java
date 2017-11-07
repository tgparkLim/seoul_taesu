package com.taesu.seoul2.FindPatient_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.taesu.seoul2.R;

public class FindpatientPost extends AppCompatActivity {

    String urlAddress = "http://13.124.11.28/taesu/postfindpatient.php";

    EditText txtpostTitle2, txtpostNic2, txtpostAge2, txtpostPhone2, txtpostCertify2, txtpostJob2, txtpostAddress2, txtpostCost2, txtpostTerm2, txtpostcontent2;

    String txtpostGender2, txtposthopegen2;
    Button backBtn2, saveBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpatient_post);

        txtpostTitle2 =(EditText) findViewById(R.id.Edit_fcpost_title2);
        txtpostNic2=(EditText) findViewById(R.id.Edit_fcpost_nic2);
//        txtpostGender1=(EditText) findViewById(R.id.Edit_fcpost_gender1);
        txtpostAge2=(EditText) findViewById(R.id.Edit_fcpost_age2);
        txtpostCertify2=(EditText) findViewById(R.id.Edit_fcpost_certify2);
        txtpostJob2=(EditText) findViewById(R.id.Edit_fcpost_job2);
        txtpostAddress2=(EditText) findViewById(R.id.Edit_fcpost_address2);
        txtpostPhone2 =(EditText) findViewById(R.id.Edit_fcpost_phone2);
        txtpostCost2 =(EditText) findViewById(R.id.Edit_fcpost_cost2);
        txtpostTerm2=(EditText) findViewById(R.id.Edit_fcpost_term2);
//        txtposthopegen1
        txtpostcontent2=(EditText) findViewById(R.id.Edit_fcpost_content2);

        RadioGroup rgcare2 = (RadioGroup) findViewById(R.id.rg_postgender2);
        int genderGroupID2 = rgcare2.getCheckedRadioButtonId();
        txtpostGender2 = ((RadioButton) findViewById(genderGroupID2)).getText().toString();

        rgcare2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton genderButton = (RadioButton) findViewById(i);
                txtpostGender2 = genderButton.getText().toString();
            }
        });

        RadioGroup rghope2 = (RadioGroup) findViewById(R.id.rg_posthopegender2);
        int genderGroupID3 = rghope2.getCheckedRadioButtonId();
        txtposthopegen2 = ((RadioButton) findViewById(genderGroupID3)).getText().toString();

        rghope2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton genderButton2 = (RadioButton) findViewById(i);
                txtposthopegen2 = genderButton2.getText().toString();
            }
        });

        saveBtn2 = (Button) findViewById(R.id.saveBtn2);

        saveBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindpatientPostSender fp = new FindpatientPostSender
                        (FindpatientPost.this,
                                urlAddress,
                                txtpostTitle2,
                                txtpostNic2,
                                txtpostGender2,
                                txtpostAge2,
                                txtpostPhone2,
                                txtpostCertify2,
                                txtpostJob2,
                                txtpostAddress2,
                                txtpostCost2,
                                txtpostTerm2,
                                txtposthopegen2,
                                txtpostcontent2);
                fp.execute();
            }
        });

        backBtn2 = (Button)findViewById(R.id.btn_postp);
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //RECEIVE
        Intent i = this.getIntent();
    }
}
