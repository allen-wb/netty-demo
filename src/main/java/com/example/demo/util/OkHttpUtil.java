package com.example.demo.util;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Allen on 2018/12/22.
 */
public class OkHttpUtil {

    private final static MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain");

    private static OkHttpClient client;

    static {
        client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .build();
    }

    private static String executeReq(Request request) {
        String res = null;

        try {
            res = client.newCall(request).execute().body().toString();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return res;
    }

    public static String post(String url, String param) {
        Request request = new Request
                .Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE_TEXT, param))
                .build();
        return executeReq(request);
    }
}
