/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author hoan
 */
public class api {

    private static final String loginAPI = "https://datkham-api.kcb.vn/api/v1/accounts/signin";
    private static final String GetUserInfoAPI = "https://datkham-api.kcb.vn/api/v1/patients/info";
    private static final String GetVaccinePassportAPI = "https://datkham-api.kcb.vn/api/v1/patients/get-vaccine-passport/";

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();

    public String LoginToSSKDT(String username, String password) throws IOException {
        JSONObject data = new JSONObject();
        try {
            data.put("username", username);
            data.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try
        {
           String authToken = this.CreatePostReq(loginAPI, data).getJSONObject("data").getString("access_token"); 
           return authToken;
        }
        catch(JSONException e)
        {
            return null;
        }
    }

    public JSONObject GetUserInfo(String username, String password) throws IOException {
        JSONObject data = new JSONObject();
        try {
            data.put("username", username);
            data.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject response = this.CreatePostReq(loginAPI, data);
        return response;
    }

    public JSONObject CreatePostReq(String url) throws IOException {
        RequestBody reqBody = RequestBody.create(null, new byte[0]);
        Request request = new Request.Builder().url(url).post(reqBody).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return new JSONObject(response.body().string());
        }
    }

    public JSONObject CreateGetReq(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return new JSONObject(response.body().string());
        }
    }

    //Methods overloading
    public JSONObject CreatePostReq(String url, JSONObject obj) throws IOException {
        RequestBody reqBody = RequestBody.create(JSON, obj.toString());
        Request request = new Request.Builder().url(url).post(reqBody).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return new JSONObject(response.body().string());
        }
    }

    public JSONObject CreateGetReq(String url, String authToken) throws IOException {
        Request request = new Request.Builder().url(url).addHeader("Authorization", "Bearer " + authToken).build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return new JSONObject(response.body().string());
        }
    }
}

class Test {

    public static void main(String[] args) throws IOException {
        api a = new api();
        String res = a.LoginToSSKDT("0989194477", "hoan1234");
        System.out.println(res);
    }
}
