package com.bailiangjin.httprequest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bailiangjin.httprequest.net.origin.HttpUtils;

/**
 * Created by bailiangjin on 2017/2/14.
 */

public class OriginalRequestActivity extends AbsRequestActivity{

    protected String getRequestUrl="http://www.baidu.com";
    protected String postRequestUrl=getRequestUrl;
    protected String postParamString="";


    public static void start(Activity activity){
        Intent intent = new Intent(activity,OriginalRequestActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv_title.setText("原始方式请求");
    }

    @Override
    public void onClick_get(View view) {
        updateRequestData("Get请求方式",getRequestUrl);
        HttpUtils.doGetAsyn(getRequestUrl, new HttpUtils.CallBack() {
            @Override
            public void onRequestComplete(String result) {
                updateResponseData(result);
            }
        });
    }

    @Override
    public void onClick_post(View view) {
        try {
            updateRequestData("Post请求方式",postRequestUrl+"\nparamJson：\n"+postParamString);
            HttpUtils.doPostAsyn(postRequestUrl, postParamString, new HttpUtils.CallBack() {
                @Override
                public void onRequestComplete(String result) {
                    updateResponseData(result);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
