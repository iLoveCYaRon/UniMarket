package moe.sui.unimarket.datamodel;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MediaAPI {
    private static String TAG = "MediaAPI";
    private static final String MEDIAPATH = "/wp-json/wp/v2/media/";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    // 根据id取回Media
    public static Media getMedia(int id) {
        // 建立GET请求
        Request request = new Request.Builder()
                .url(Config.SITE + MEDIAPATH + id)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) return null;
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Media.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
