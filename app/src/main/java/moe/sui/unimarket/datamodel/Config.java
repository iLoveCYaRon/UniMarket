package moe.sui.unimarket.datamodel;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.*;

public class Config {
    public static final String SITE = "https://shop.sui.moe";
    public static final String KEY = "ck_42acbbd45b697dd8e6d06d4f656b476d95b30cc6";
    public static final String SECRET = "cs_7befbb714ccb81ed0fcf03cc7e96ea9ee4a90611";
    public static final MediaType JSON = MediaType.parse("application/json,text/plain");
    public static final String SUPERTOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvc2hvcC5zdWkubW9lIiwiaWF0IjoxNTg4MTY1NzA5LCJuYmYiOjE1ODgxNjU3MDksImV4cCI6MTU4ODc3MDUwOSwiZGF0YSI6eyJ1c2VyIjp7ImlkIjoiMSJ9fX0.aHolIjkN5Ym4CQN7vRQNXL-drvRjF2yqHJtuUOCddH0";

    public static RequestBody createBodyFromJson(String json) {

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
}
