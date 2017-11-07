package com.taesu.seoul2.MySQL;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by park on 2017-10-29.
 */

public class DataPackagerMainNearPlace {

    String query1;
    String query2;

    public DataPackagerMainNearPlace(String query1, String query2) {
        this.query1 = query1;
        this.query2 = query2;
    }

    public String packData() {

        JSONObject jo = new JSONObject();
        StringBuffer queryString = new StringBuffer();

        try {

            jo.put("latitude", query1);
            jo.put("longitude", query2);
            //jo.put("Query", query);

            Boolean firstValue = true;
            Iterator it = jo.keys();

            do {

                String key = it.next().toString();
                String value = jo.get(key).toString();

                if(firstValue) {

                    firstValue = false;

                } else {

                    queryString.append("&");

                }

                queryString.append(URLEncoder.encode(key, "UTF-8"));
                queryString.append("=");
                queryString.append(URLEncoder.encode(value, "UTF-8"));

            } while (it.hasNext());

            return queryString.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }

}
