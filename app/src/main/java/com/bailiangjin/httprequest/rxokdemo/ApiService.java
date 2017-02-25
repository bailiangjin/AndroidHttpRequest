package com.bailiangjin.httprequest.rxokdemo;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.BaseData;
import com.bailiangjin.httprequest.rxokdemo.model.PostInfo;
import com.bailiangjin.httprequest.rxokdemo.model.WeatherInfo;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 网络请求Service 方法汇总 将调用的方法在此处进行rx绑定
 * Created by bailiangjin on 2017/2/15.
 */

public interface ApiService {

    @GET("data/sk/101091001.html")
    Observable<WeatherInfo> rxGetTest();

    @GET("query?type=yuantong&postid=200382770316")
    Observable<PostInfo> rxGetPostInfo();

    /**
     * Post方式请求需要添加 FormUrlEncoded标识 使用公有的异常处理 不用 BaseData<> 包裹
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/")
    Observable<PostInfo> rxPostTest1(@FieldMap Map<String, String> map);


    /**
     * Post方式请求需要添加 FormUrlEncoded标识
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/")
    Observable<BaseData<PostInfo>> rxPostTest2(@FieldMap Map<String, String> map);

}
