package moe.sui.unimarket.datamodel;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;
import java.util.Objects;

import okhttp3.*;

public class PostAPI {
    private static String TAG = "PostAPI";
    private static final String POSTPATH = "/wp-json/wp/v2/posts/";
    private static final OkHttpClient client = new OkHttpClient();

    PostAPI(String site, String token) {
        this.site = site;
        this.token = token;
    }

    private RequestBody createBodyFromJson(String json) {

        StringReader stringReader = new StringReader(json);
        JsonReader jsonReader = new Gson().newJsonReader(stringReader);

        FormBody.Builder formBuilder = new FormBody.Builder();
        //读取JSON建立POST表格
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String name = jsonReader.nextName();
                formBuilder.add(name, jsonReader.nextString());
            }
            jsonReader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return formBuilder.build();
    }

    // 根据id取回Post，成功返回取得的Post，失败返回空值
    public Post getPost(int id) {

        //建立GET请求
        Request request = new Request.Builder()
                .url(site + POSTPATH + id)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) return null;
            Gson gson = new Gson();
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Post.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 请求新增文章，如果成功则返回新增的文章，不成功返回空值
    public Post addPost(String postJson) {
        RequestBody formBody = createBodyFromJson(postJson);

        // 建立POST请求, 需要鉴权
        Request request = new Request.Builder()
                .url(site + POSTPATH)
                .addHeader("Authorization", "Bearer " + token)
                .post(formBody)
                .build();

        //发送请求并输出响应
        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) return null;
            //通过String新建JsonObject取ID
            Gson gson = new Gson();
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Post.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 请求删除文章，成功返回被删除的文章信息，不成功返回空值
    public Post deletePost(int id) {

        Request request = new Request.Builder()
                .url(site + POSTPATH + id)
                .addHeader("Authorization", "Bearer " + token)
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) return null;

            Gson gson = new Gson();
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Post.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    // 更新文章，arg1为文章ID，arg2为文章内容，接收Json格式的字符串
    public Post updatePost(int id, String postJson) {

        //建立POST请求并鉴权
        Request request = new Request.Builder()
                .url(site + POSTPATH + id)
                .addHeader("Authorization", "Bearer " + token)
                .post(createBodyFromJson(postJson))
                .build();

        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) return null;
            //通过String新建JsonObject取ID
            Gson gson = new Gson();
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Post.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private String site;
    private String token;
}
