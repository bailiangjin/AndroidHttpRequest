package com.bailiangjin.httprequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bailiangjin.httprequest.activity.OkHttpRequestActivity;
import com.bailiangjin.httprequest.activity.OriginalRequestActivity;
import com.bailiangjin.httprequest.activity.RxRetrofitOkHttpRequestActivity;
import com.bailiangjin.httprequest.activity.TestFileDownLoadAndUploadActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_Origin(View view){
        OriginalRequestActivity.start(MainActivity.this);
    }
    public void onClick_OK(View view){
        OkHttpRequestActivity.start(MainActivity.this);
    }

    public void onClick_rx_ok(View view){
        RxRetrofitOkHttpRequestActivity.start(MainActivity.this);
    }

    public void onClick_file(View view){
        TestFileDownLoadAndUploadActivity.start(MainActivity.this);
    }
}
