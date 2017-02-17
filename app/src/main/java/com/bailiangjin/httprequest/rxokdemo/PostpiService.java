package com.bailiangjin.httprequest.rxokdemo;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.tools.RetrofitCollection;

import retrofit2.Retrofit;

/**
 * Created by bailiangjin on 2017/2/16.
 */

public enum PostpiService {
    INSTANCE;
    private ApiService apiService;

    PostpiService() {
        Retrofit retrofit = RetrofitCollection.BAIDU_INSTANCE.getRetrofit();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
