package com.bailiangjin.httprequest.rxokdemo;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.BaseData;
import com.bailiangjin.httprequest.rxokdemo.model.PostInfo;
import com.bailiangjin.httprequest.rxokdemo.model.TestStrResult;
import com.bailiangjin.httprequest.rxokdemo.model.WeatherInfo;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by bailiangjin on 2017/2/15.
 */

public interface ApiService {

    @GET("/data/sk/101091001.html")
    Observable<WeatherInfo> rxGetTest();

    @GET("/query?type=yuantong&postid=200382770316")
    Observable<PostInfo> rxGetPostInfo();

    @FormUrlEncoded
    @POST("/")
    Observable<BaseData<TestStrResult>> rxPostTest(@FieldMap Map<String, String> map);


}
