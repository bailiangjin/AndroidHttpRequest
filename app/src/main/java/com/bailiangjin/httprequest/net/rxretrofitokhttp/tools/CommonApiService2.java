package com.bailiangjin.httprequest.net.rxretrofitokhttp.tools;

import com.bailiangjin.httprequest.service.ApiService;

import retrofit2.Retrofit;

/**
 * Created by bailiangjin on 2017/2/16.
 */

public enum CommonApiService2 {
    INSTANCE;
    private ApiService apiService;

    CommonApiService2() {
        Retrofit retrofit = CommonRetrofitClient.INSTANCE2.getRetrofit();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
