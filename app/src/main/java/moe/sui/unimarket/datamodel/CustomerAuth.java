package moe.sui.unimarket.datamodel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.*;

public class CustomerAuth {
    private static String TAG = "UserAuth";

    private static final OkHttpClient client = new OkHttpClient();

    public static String auth(String username, String password) throws IOException {
        // RequestBody表格内容填入
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        //利用body和url建立POST request
        Request request = new Request.Builder()
                .url("https://shop.sui.moe/wp-json/jwt-auth/v1/token")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return null;
                //throw new IOException("Unexpected code " + response);
            }
            //获取response中的token
            JSONObject rec = new JSONObject(response.body().string());
            return rec.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean authValidate(String token) throws IOException {
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");

        Request request = new Request.Builder()
                .url("https://shop.sui.moe/wp-json/jwt-auth/v1/token/validate")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + token)
                .build();
        Response response = client.newCall(request).execute();

        return  response.isSuccessful();
    }

}
