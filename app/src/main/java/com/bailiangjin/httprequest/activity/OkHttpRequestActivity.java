package com.bailiangjin.httprequest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bailiangjin.httprequest.net.origin.HttpCallback;
import com.bailiangjin.httprequest.net.okhttp.OKHttpUtils;

import java.io.IOException;

/**
 * Created by bailiangjin on 2017/2/14.
 */

public class OkHttpRequestActivity extends AbsRequestActivity{

    protected String getRequestUrl="http://www.baidu.com";
    protected String postRequestUrl=getRequestUrl;
    protected String postParamString="";

    public static void start(Activity activity){
        Intent intent = new Intent(activity, OkHttpRequestActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv_title.setText("OKHttp方式请求");
    }

    @Override
    public void onClick_get(View view) {
        updateRequestData("Get请求方式",getRequestUrl);
        try {
            OKHttpUtils.get(getRequestUrl, new HttpCallback() {
                @Override
                public void onSuccess(String json) {
                    updateResponseData("onSuccess:"+json);
                }

                @Override
                public void onFailed(String json) {
                    updateResponseData("onFailed:"+json);
                }

                @Override
                public void onError(String json) {
                    updateResponseData("onError:"+json);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick_post(View view) {
        updateRequestData("Post请求方式",getRequestUrl);
        try {
            OKHttpUtils.post(getRequestUrl,postParamString, new HttpCallback() {
                @Override
                public void onSuccess(String json) {
                    updateResponseData("onSuccess:"+json);
                }

                @Override
                public void onFailed(String json) {
                    updateResponseData("onFailed:"+json);
                }

                @Override
                public void onError(String json) {
                    updateResponseData("onError:"+json);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
