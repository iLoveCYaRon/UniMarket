package moe.sui.unimarket.datamodel;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CategoryAPI {
    private static String TAG = "CategoryAPI";
    private static final String CategoryPATH = "/wp-json/wc/v3/products/categories";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static List<Category> listCategory(){
        Request request = new Request.Builder()
                .url(Config.SITE + CategoryPATH)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "text/plain")
                .addHeader("Authorization", Config.SUPERTOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) Log.e(TAG, "listCategory: "+ Objects.requireNonNull(response.body()).string());
            // 如果成功返回Category数组
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), new TypeToken<List<Category>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
