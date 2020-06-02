package moe.sui.unimarket.datamodel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.*;

public class PostAPI {
    private static String TAG = "PostAPI";
    private static final String POSTPATH = "/wp-json/wp/v2/posts/";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static List<Post> listPost() {
        //建立GET请求
        Request request = new Request.Builder()
                .url(Config.SITE + POSTPATH)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) return null;
            Gson gson = new Gson();
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), new TypeToken<List<Post>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 根据id取回Post，成功返回取得的Post，失败返回空值
    public static Post getPost(int id) {

        //建立GET请求
        Request request = new Request.Builder()
                .url(Config.SITE + POSTPATH + id)
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
    public Post addPost(Post post) {
        String postJson = gson.toJson(post, Post.class);

        RequestBody body = RequestBody.create(Config.JSON, postJson);

        // 建立POST请求, 需要鉴权
        Request request = new Request.Builder()
                .url(Config.SITE + POSTPATH)
                .addHeader("Authorization", "Bearer " + Config.SUPERTOKEN)
                .post(body)
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
                .url(Config.SITE + POSTPATH + id)
                .addHeader("Authorization", "Bearer " + Config.SUPERTOKEN)
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
                .url(Config.SITE + POSTPATH + id)
                .addHeader("Authorization", "Bearer " + Config.SUPERTOKEN)
                .post(Config.createBodyFromJson(postJson))
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

}
