package moe.sui.unimarket.datamodel;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;

import okhttp3.*;

public class CustomerAPI {

    private static String TAG = "CustomerAPI";
    private static final String CUSPATH = "/wp-json/wc/v3/customers/";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static Customer createCustomer(Customer customer) {

        // 建立请求体
        String postJson = gson.toJson(customer, Customer.class);
        RequestBody body = RequestBody.create(Config.JSON, postJson);

        // 建立POST请求, 需要鉴权
        Request request = new Request.Builder()
                .url(Config.SITE + CUSPATH)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "text/plain")
                .addHeader("Authorization", Config.SUPERTOKEN)
                .post(body)
                .build();

        //发送请求并输出响应
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) Log.e(TAG, "createCustomer: "+response.body().string());
            // 如果成功返回，发回用户信息
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Customer retrieveCustomer(int id) {
        Request request = new Request.Builder()
                .url(Config.SITE + CUSPATH + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", Config.SUPERTOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) Log.e(TAG, "retrieveCustomer: "+response.body().string());
            // 如果成功返回，发回用户信息
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Customer updateCustomer(int id, Customer customer) {
        RequestBody body = RequestBody.create(Config.JSON, gson.toJson(customer, Customer.class));

        Request request = new Request.Builder()
                .url(Config.SITE + CUSPATH + id)
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", Config.SUPERTOKEN)
                .addHeader("Content-Type", "text/plain")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) Log.e(TAG, "updateCustomer: "+response.body().string());
            // 如果成功返回，发回用户信息
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
