package com.bailiangjin.httprequest.net.rxretrofitokhttp.tools;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit 集合 可以通过添加枚举元素的方式 方便地添加 不同 root url的 retrofit
 * @author bailiangjin 2017-02-16
 */
public enum RetrofitCollection {
    WEATHER_INSTANCE("http://www.weather.com.cn"),
    BAIDU_INSTANCE("http://www.kuaidi100.com");
    private Retrofit retrofit;

    RetrofitCollection(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .client(MyOkHttpClient.INSTANCE.getOkHttpClient())
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

