package com.taesu.seoul2.Login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uhees on 2017-10-03.
 */

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://13.124.11.28/taesu/UserRegister.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userNic, String userGender, String userAge, String userAddress, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userNic", userNic);
        parameters.put("userGender", userGender);
        parameters.put("userAge", userAge);
        parameters.put("userAddress", userAddress);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
