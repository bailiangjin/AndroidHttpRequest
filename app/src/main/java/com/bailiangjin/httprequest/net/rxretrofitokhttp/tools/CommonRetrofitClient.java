package com.bailiangjin.httprequest.net.rxretrofitokhttp.tools;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author bailiangjin 2017-02-16
 */
public enum CommonRetrofitClient {
    INSTANCE("http://www.weather.com.cn"),
    INSTANCE2("http://www.weather");
    private Retrofit retrofit;

    CommonRetrofitClient(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .client(CommonOkHttpClient.INSTANCE.getOkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(XywyCallAdapterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }
}

