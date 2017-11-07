package com.taesu.seoul2.FindPatient_detail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import com.taesu.seoul2.MySQL.Connector;
import com.taesu.seoul2.MySQL.DataPackagerFindPatientPost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

/**
 * Created by uhees on 2017-10-30.
 */

public class FindpatientPostSender extends AsyncTask<Void, Void, String> {

    Context c;
    String urlAddress2, txtpostGender2, txtposthopegen2;
    EditText txtpostTitle2, txtpostNic2, txtpostAge2, txtpostPhone2, txtpostCertify2, txtpostJob2, txtpostAddress2, txtpostCost2, txtpostTerm2, txtpostHopegent2, txtpostContent2;

    FindpatientPostModel findpatientPostModel;

    ProgressDialog pd;

    public FindpatientPostSender(Context c, String urlAddress2,
                                   EditText txtpostTitle2,EditText txtpostNic2,String txtpostGender2,EditText txtpostAge2, EditText txtpostPhone2, EditText txtpostCertify2, EditText txtpostJob2, EditText txtpostAddress2, EditText txtpostCost2, EditText txtpostTerm2, String txtposthopegen2,EditText txtpostcontent2) {
        this.c = c;
        this.urlAddress2 = urlAddress2;
        this.txtpostTitle2 = txtpostTitle2;
        this.txtpostNic2 = txtpostNic2;
        this.txtpostGender2 = txtpostGender2;
        this.txtpostAge2 = txtpostAge2;
        this.txtpostPhone2 = txtpostPhone2;
        this.txtpostCertify2 = txtpostCertify2;
        this.txtpostJob2 = txtpostJob2;
        this.txtpostAddress2 = txtpostAddress2;
        this.txtpostCost2 = txtpostCost2;
        this.txtpostTerm2 = txtpostTerm2;
        this.txtposthopegen2 = txtposthopegen2;
        this.txtpostContent2 = txtpostcontent2;

        findpatientPostModel = new FindpatientPostModel();
        findpatientPostModel.setPostTitle2(txtpostTitle2.getText().toString());
        findpatientPostModel.setPostNic2(txtpostNic2.getText().toString());
        findpatientPostModel.setPostgen2(txtpostGender2.toString());
        findpatientPostModel.setPostage2(txtpostAge2.getText().toString());
        findpatientPostModel.setPostphone2(txtpostPhone2.getText().toString());
        findpatientPostModel.setPostcertify2(txtpostCertify2.getText().toString());
        findpatientPostModel.setPostjob2(txtpostJob2.getText().toString());
        findpatientPostModel.setPostaddress2(txtpostAddress2.getText().toString());
        findpatientPostModel.setPostcost2(txtpostCost2.getText().toString());
        findpatientPostModel.setPostterm2(txtpostTerm2.getText().toString());
        findpatientPostModel.setPosthopegen2(txtposthopegen2.toString());
        findpatientPostModel.setPostcontent2(txtpostcontent2.getText().toString());

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
                txtpostTitle2.setText("");
                txtpostNic2.setText("");
                //txtpostGender1.setText("");
                txtpostAge2.setText("");
                txtpostAddress2.setText("");
                txtpostPhone2.setText("");
                txtpostCost2.setText("");
                txtpostTerm2.setText("");
                //txtposthopegen1.setText("");
                txtpostContent2.setText("");

            }
        }

    }

    private String send() {

        HttpURLConnection con = Connector.connect(urlAddress2);

        if(con == null) {

            return null;

        }

        try {

            OutputStream os=con.getOutputStream();

            //WRITE
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(new DataPackagerFindPatientPost(findpatientPostModel).packData());

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

