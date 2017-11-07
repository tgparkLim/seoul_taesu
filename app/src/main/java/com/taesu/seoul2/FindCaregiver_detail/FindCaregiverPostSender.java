package com.taesu.seoul2.FindCaregiver_detail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import com.taesu.seoul2.MySQL.Connector;
import com.taesu.seoul2.MySQL.DataPackagerFindCaregiverPost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

/**
 * Created by park on 2017-10-06.
 */

public class FindCaregiverPostSender extends AsyncTask<Void, Void, String> {

    Context c;
    String urlAddress, txtpostGender1, txtposthopegen1;
    EditText txtpostTitle1, txtpostNic1, txtpostAge1, txtpostSympton1, txtpostAddress1, txtpostPhone1, txtpostCost1, txtpostTerm1, txtpostcontent1;

    FindCaregiverPostModel findCaregiverPostModel;

    ProgressDialog pd;

    public FindCaregiverPostSender(Context c, String urlAddress,
                                   EditText txtpostTitle1,EditText txtpostNic1,String txtpostGender1,EditText txtpostAge1,EditText txtpostSympton1,EditText txtpostAddress1,EditText txtpostPhone1,EditText txtpostCost1,EditText txtpostTerm1,String txtposthopegen1,EditText txtpostcontent1) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.txtpostTitle1 = txtpostTitle1;
        this.txtpostNic1 = txtpostNic1;
        this.txtpostGender1 = txtpostGender1;
        this.txtpostAge1 = txtpostAge1;
        this.txtpostSympton1 = txtpostSympton1;
        this.txtpostAddress1 = txtpostAddress1;
        this.txtpostPhone1 = txtpostPhone1;
        this.txtpostCost1 = txtpostCost1;
        this.txtpostTerm1 = txtpostTerm1;
        this.txtposthopegen1 = txtposthopegen1;
        this.txtpostcontent1 = txtpostcontent1;

        findCaregiverPostModel = new FindCaregiverPostModel();
        findCaregiverPostModel.setPostTitle1(txtpostTitle1.getText().toString());
        findCaregiverPostModel.setPostNic1(txtpostNic1.getText().toString());
        findCaregiverPostModel.setPostgen1(txtpostGender1.toString());
        findCaregiverPostModel.setPostage1(txtpostAge1.getText().toString());
        findCaregiverPostModel.setPostsympton1(txtpostSympton1.getText().toString());
        findCaregiverPostModel.setPostaddress1(txtpostAddress1.getText().toString());
        findCaregiverPostModel.setPostphone1(txtpostPhone1.getText().toString());
        findCaregiverPostModel.setPostcost1(txtpostCost1.getText().toString());
        findCaregiverPostModel.setPostterm1(txtpostTerm1.getText().toString());
        findCaregiverPostModel.setPosthopegen1(txtposthopegen1.toString());
        findCaregiverPostModel.setPostcontent1(txtpostcontent1.getText().toString());

    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("send");
        pd.setMessage("Sending... Please wait");
        pd.show();

    }

    @Override
    protected String doInBackground(Void... params) {
        return this.send();
    }

    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);

        pd.dismiss();

        if(s == null) {
            Toast.makeText(c, "Unsuccessful, Null returned", Toast.LENGTH_SHORT).show();
        } else {
            if(s == "Bad Response") {
                Toast.makeText(c,"Unsuccessful,Bad Response returned",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(c,"Successfully Saved",Toast.LENGTH_SHORT).show();

                //CLEAR UI
                txtpostTitle1.setText("");
                txtpostNic1.setText("");
                //txtpostGender1.setText("");
                txtpostAge1.setText("");
                txtpostSympton1.setText("");
                txtpostAddress1.setText("");
                txtpostPhone1.setText("");
                txtpostCost1.setText("");
                txtpostTerm1.setText("");
                //txtposthopegen1.setText("");
                txtpostcontent1.setText("");

            }
        }

    }

    private String send() {

        HttpURLConnection con = Connector.connect(urlAddress);

        if(con == null) {

            return null;

        }

        try {

            OutputStream os=con.getOutputStream();

            //WRITE
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(new DataPackagerFindCaregiverPost(findCaregiverPostModel).packData());

            bw.flush();
            //RELEASE
            bw.close();
            os.close();

            //SUCCESS OR NOT??
            int responseCode=con.getResponseCode();
            if(responseCode==con.HTTP_OK)
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer response=new StringBuffer();

                String line;
                while ((line=br.readLine()) != null)
                {
                    response.append(line);
                    //URLEncoder.encode(line, "UTF-8");
                }

                br.close();
                return response.toString();
            }else {
                return "Bad Response";
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
