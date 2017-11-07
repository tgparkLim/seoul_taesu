package com.taesu.seoul2.FindCaregiver_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.taesu.seoul2.R;

public class FindCaregiverPost extends AppCompatActivity {

    String urlAddress = "http://13.124.11.28/taesu/postfindcaregiver.php";

    EditText txtpostTitle1, txtpostNic1, txtpostAge1, txtpostSympton1, txtpostAddress1, txtpostPhone1, txtpostCost1, txtpostTerm1, txtpostcontent1;

    String txtpostGender1, txtposthopegen1;
    private Button saveBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findcaregiver_post);

        txtpostTitle1 =(EditText) findViewById(R.id.Edit_fcpost_title1);
        txtpostNic1=(EditText) findViewById(R.id.Edit_fcpost_nic1);
//        txtpostGender1=(EditText) findViewById(R.id.Edit_fcpost_gender1);
        txtpostAge1=(EditText) findViewById(R.id.Edit_fcpost_age1);
        txtpostSympton1=(EditText) findViewById(R.id.Edit_fcpost_sympton1);
        txtpostAddress1=(EditText) findViewById(R.id.Edit_fcpost_address1);
        txtpostPhone1 =(EditText) findViewById(R.id.Edit_fcpost_phone1);
        txtpostCost1 =(EditText) findViewById(R.id.Edit_fcpost_cost1);
        txtpostTerm1=(EditText) findViewById(R.id.Edit_fcpost_term1);
//        txtposthopegen1
        txtpostcontent1=(EditText) findViewById(R.id.Edit_fcpost_content1);

        RadioGroup rgcare1 = (RadioGroup) findViewById(R.id.rg_postgender1);
        int genderGroupID = rgcare1.getCheckedRadioButtonId();
        txtpostGender1 = ((RadioButton) findViewById(genderGroupID)).getText().toString();

        rgcare1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton genderButton = (RadioButton) findViewById(i);
                txtpostGender1 = genderButton.getText().toString();
            }
        });

        RadioGroup rghope1 = (RadioGroup) findViewById(R.id.rg_posthopegender1);
        int genderGroupID2 = rghope1.getCheckedRadioButtonId();
        txtposthopegen1 = ((RadioButton) findViewById(genderGroupID2)).getText().toString();

        rghope1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton genderButton = (RadioButton) findViewById(i);
                txtposthopegen1 = genderButton.getText().toString();
            }
        });

        saveBtn = (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindCaregiverPostSender fs = new FindCaregiverPostSender
                        (FindCaregiverPost.this,
                                urlAddress,
                                txtpostTitle1,
                                txtpostNic1,
                                txtpostGender1,
                                txtpostAge1,
                                txtpostSympton1,
                                txtpostAddress1,
                                txtpostPhone1,
                                txtpostCost1,
                                txtpostTerm1,
                                txtposthopegen1,
                                txtpostcontent1);
                fs.execute();
            }
        });

        backBtn = (Button)findViewById(R.id.btn_postf);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //RECEIVE
        Intent i = this.getIntent();
    }
}
