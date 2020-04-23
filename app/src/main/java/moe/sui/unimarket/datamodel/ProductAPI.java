package moe.sui.unimarket.datamodel;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.*;

public class ProductAPI {
    private static String TAG = "ProductAPI";
    private static final String PRODUCTPATH = "/wp-json/wc/v3/products/";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    // 列出商品，默认列出10个最新商品
    public static List<Product> listProduct() {

        Request request = new Request.Builder()
                .url(Config.SITE + PRODUCTPATH)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", Config.SUPERTOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) Log.e(TAG, "listProduct: "+ Objects.requireNonNull(response.body()).string());
            // 如果成功返回Product数组
            List<Product> test = gson.fromJson(Objects.requireNonNull(response.body()).string(), new TypeToken<List<Product>>(){}.getType());
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), new TypeToken<List<Product>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
