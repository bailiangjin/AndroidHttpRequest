package com.bailiangjin.httprequest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.CommonResponseSubscribe;
import com.bailiangjin.httprequest.net.rxretrofitokhttp.tools.RxOkServiceProvider;
import com.bailiangjin.httprequest.service.model.WeatherInfo;
import com.bailiangjin.httprequest.utils.GsonUtils;

/**
 * Created by bailiangjin on 2017/2/14.
 */

public class RxRetrofitOkHttpRequestActivity extends AbsRequestActivity {

    protected String getRequestUrl = "http://www.baidu.com";
    protected String postRequestUrl = getRequestUrl;
    protected String postParamString = "";

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
        updateRequestData("Get请求方式", getRequestUrl);
        RxOkServiceProvider.testGet(new CommonResponseSubscribe<WeatherInfo>() {
            @Override
            public void onNext(WeatherInfo testStrResultBaseData) {
                Toast.makeText(RxRetrofitOkHttpRequestActivity.this, "get请求结束:" + GsonUtils.toJson(testStrResultBaseData), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick_post(View view) {
        updateRequestData("Post请求方式", getRequestUrl);
        RxOkServiceProvider.testGet2(new CommonResponseSubscribe<WeatherInfo>() {
            @Override
            public void onNext(WeatherInfo testStrResultBaseData) {
                Toast.makeText(RxRetrofitOkHttpRequestActivity.this, "get请求结束2:" + GsonUtils.toJson(testStrResultBaseData), Toast.LENGTH_SHORT).show();
            }
        });
//        RxOkServiceProvider.testPost(new CommonResponseSubscribe<BaseData<TestStrResult>>() {
//            @Override
//            public void onNext(BaseData<TestStrResult> testStrResultBaseData) {
//
//            }
//        });

    }
}
