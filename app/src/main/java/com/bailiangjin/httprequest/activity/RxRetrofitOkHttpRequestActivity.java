package com.bailiangjin.httprequest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.CommonResponseSubscriber;
import com.bailiangjin.httprequest.rxokdemo.RxOkServiceProvider;
import com.bailiangjin.httprequest.rxokdemo.model.PostInfo;
import com.bailiangjin.httprequest.rxokdemo.model.WeatherInfo;
import com.bailiangjin.httprequest.utils.GsonUtils;

/**
 * RxRetrofitOkHttp 结合的请求网络调用的示例 该示例仅展示了get方式请求 post方式与get无太大区别
 * Created by bailiangjin on 2017/2/14.
 */

public class RxRetrofitOkHttpRequestActivity extends AbsRequestActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv_title.setText("RxRetrofitOkHttp方式请求");
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, RxRetrofitOkHttpRequestActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick_get(View view) {
        updateRequestData("Get请求方式", "");
        RxOkServiceProvider.testWeatherGet(new CommonResponseSubscriber<WeatherInfo>() {
            @Override
            public void onNext(WeatherInfo weatherInfo) {
                //Toast.makeText(RxRetrofitOkHttpRequestActivity.this, "get请求结束:" + GsonUtils.toJson(weatherInfo), Toast.LENGTH_SHORT).show();
                String rst = null == weatherInfo ? null : GsonUtils.toJson(weatherInfo);
                updateResponseData(rst);

            }
        });
    }

    @Override
    public void onClick_post(View view) {
        updateRequestData("Get请求方式", "");
        //此处写的是测试获取快递信息的请求 调用方式为get
        RxOkServiceProvider.testExpressGet(new CommonResponseSubscriber<PostInfo>() {
            @Override
            public void onNext(PostInfo postInfo) {
                //Toast.makeText(RxRetrofitOkHttpRequestActivity.this, "get请求结束2:" +rst , Toast.LENGTH_SHORT).show();
                String rst = null == postInfo ? null : GsonUtils.toJson(postInfo);
                updateResponseData(rst);
            }
        });
    }
}
