package com.bailiangjin.httprequest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bailiangjin.httprequest.R;

/**
 * Created by bailiangjin on 2017/2/14.
 */

public abstract class AbsRequestActivity extends Activity {

    TextView tv_title;
    TextView tv_request;
    TextView tv_response;


    Button btn_get;
    Button btn_post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_request);
        initView();
    }

    private void initView() {
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_request= (TextView) findViewById(R.id.tv_request);
        tv_response= (TextView) findViewById(R.id.tv_response);

        btn_get= (Button) findViewById(R.id.btn_get);
        btn_post= (Button) findViewById(R.id.btn_post);

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_get(view);
            }
        });

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_post(view);
            }
        });
    }
    
    

    public abstract void onClick_get(View view);

    public abstract void onClick_post(View view);
    
    protected void updateRequestData(String requestType,String requestInfo){
        tv_request.setText(TextUtils.isEmpty(requestInfo)? "请求信息为空":requestType+"\n请求参数:\n"+requestInfo);
    }

    protected void updateResponseData(final String responseInfo){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_response.setText(TextUtils.isEmpty(responseInfo)? "请求结果为空":"请求结果：\n"+responseInfo);
            }
        });
    }
}
