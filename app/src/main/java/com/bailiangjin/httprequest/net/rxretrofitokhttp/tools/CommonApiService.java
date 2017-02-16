package com.bailiangjin.httprequest.net.rxretrofitokhttp.tools;

import com.bailiangjin.httprequest.service.ApiService;

import retrofit2.Retrofit;

/**
 * Created by bailiangjin on 2017/2/16.
 */

public enum CommonApiService {
    INSTANCE;
    private ApiService apiService;

    CommonApiService() {
        Retrofit retrofit = CommonRetrofitClient.INSTANCE.getRetrofit();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
