package com.taesu.seoul2.MySQL;

import com.taesu.seoul2.FindPatient_detail.FindpatientPostModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by uhees on 2017-10-30.
 */

public class DataPackagerFindPatientPost {
    FindpatientPostModel findpatientPostModel;

    public DataPackagerFindPatientPost(FindpatientPostModel findpatientPostModel) {
        this.findpatientPostModel = findpatientPostModel;
    }

    public String packData() {

        JSONObject jo1 = new JSONObject();
        StringBuffer sb1 = new StringBuffer();

        try {

            jo1.put("title", findpatientPostModel.getPostTitle2().toString());
            jo1.put("nic", findpatientPostModel.getPostNic2().toString());
            jo1.put("gender", findpatientPostModel.getPostgen2().toString());
            jo1.put("age", findpatientPostModel.getPostage2().toString());
            jo1.put("phone", findpatientPostModel.getPostphone2().toString());
            jo1.put("certify", findpatientPostModel.getPostcertify2().toString());
            jo1.put("job", findpatientPostModel.getPostjob2().toString());
            jo1.put("address", findpatientPostModel.getPostaddress2().toString());
            jo1.put("cost", findpatientPostModel.getPostcost2().toString());
            jo1.put("term", findpatientPostModel.getPostterm2().toString());
            jo1.put("hopegender", findpatientPostModel.getPosthopegen2().toString());
            jo1.put("content", findpatientPostModel.getPostcontent2().toString());
            //URLEncoder.encode(String.valueOf(jo), "UTF-8");

            Boolean firstvalue = true;
            Iterator it = jo1.keys();

            do {

                String key = it.next().toString();
                String value = jo1.get(key).toString();

                if(firstvalue) {

                    firstvalue = false;

                } else {

                    sb1.append("&");

                }

                sb1.append(URLEncoder.encode(key, "UTF-8"));
                sb1.append("=");
                sb1.append(URLEncoder.encode(value, "UTF-8"));

            } while (it.hasNext());

            return sb1.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }

}
