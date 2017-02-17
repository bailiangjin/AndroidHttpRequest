package com.bailiangjin.httprequest.rxokdemo;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.tools.RetrofitCollection;

import retrofit2.Retrofit;

/**
 * Created by bailiangjin on 2017/2/16.
 */

public enum WeatherApiService {
    INSTANCE;
    private ApiService apiService;
    private Retrofit retrofit;

    WeatherApiService() {
        retrofit = RetrofitCollection.WEATHER_INSTANCE.getRetrofit();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }

    public String getBaseUrl() {
        return retrofit.baseUrl().toString();
    }
}
