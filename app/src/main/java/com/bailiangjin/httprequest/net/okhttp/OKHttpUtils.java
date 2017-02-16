package com.bailiangjin.httprequest.net.okhttp;

import com.bailiangjin.httprequest.net.origin.HttpCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者  liangjin.bai Email:bailiangjin@gmail.com
 * 创建时间 2017/02/14
 */

public class OKHttpUtils {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");



    public static void get(String requestUrl, final HttpCallback httpCallback) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                httpCallback.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                httpCallback.onSuccess(response.body().string());
            }
        });

    }


    public static void post(String requestUrl, final String paramJson, final HttpCallback httpCallback) throws IOException {


        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, paramJson);
        Request request = new Request.Builder()
                .url(requestUrl)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                httpCallback.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                httpCallback.onSuccess(response.body().string());
            }
        });

    }

}
