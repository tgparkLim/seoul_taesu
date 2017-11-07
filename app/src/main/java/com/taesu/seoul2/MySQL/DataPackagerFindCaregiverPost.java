package com.taesu.seoul2.MySQL;

import com.taesu.seoul2.FindCaregiver_detail.FindCaregiverPostModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by park on 2017-10-06.
 */

public class DataPackagerFindCaregiverPost {

    FindCaregiverPostModel findCaregiverPostModel;

    public DataPackagerFindCaregiverPost(FindCaregiverPostModel findCaregiverPostModel) {
        this.findCaregiverPostModel = findCaregiverPostModel;
    }

    public String packData() {

        JSONObject jo = new JSONObject();
        StringBuffer sb = new StringBuffer();

        try {

            jo.put("title", findCaregiverPostModel.getPostTitle1().toString());
            jo.put("nic", findCaregiverPostModel.getPostNic1().toString());
            jo.put("patientgender", findCaregiverPostModel.getPostgen1().toString());
            jo.put("age", findCaregiverPostModel.getPostage1().toString());
            jo.put("sympton", findCaregiverPostModel.getPostsympton1().toString());
            jo.put("address", findCaregiverPostModel.getPostaddress1().toString());
            jo.put("phone", findCaregiverPostModel.getPostphone1().toString());
            jo.put("cost", findCaregiverPostModel.getPostcost1().toString());
            jo.put("term", findCaregiverPostModel.getPostterm1().toString());
            jo.put("hopegender", findCaregiverPostModel.getPosthopegen1().toString());
            jo.put("content", findCaregiverPostModel.getPostcontent1().toString());
            //URLEncoder.encode(String.valueOf(jo), "UTF-8");

            Boolean firstvalue = true;
            Iterator it = jo.keys();

            do {

                String key = it.next().toString();
                String value = jo.get(key).toString();

                if(firstvalue) {

                    firstvalue = false;

                } else {

                    sb.append("&");

                }

                sb.append(URLEncoder.encode(key, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(value, "UTF-8"));

            } while (it.hasNext());

            return sb.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }

}
