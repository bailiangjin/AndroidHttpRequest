package com.bailiangjin.httprequest.net.rxretrofitokhttp.tools;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.BaseData;
import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.CommonResponseSubscribe;
import com.bailiangjin.httprequest.service.ApiService;
import com.bailiangjin.httprequest.service.model.TestStrResult;
import com.bailiangjin.httprequest.service.model.WeatherInfo;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;


/**
 * Created by bailiangjin on 2017/2/15.
 */

public class RxOkServiceProvider {


    public static  ApiService getApiService(){
        return CommonApiService.INSTANCE.getApiService();
    }

    public static  ApiService getApiService2(){
        return CommonApiService2.INSTANCE.getApiService();
    }

    public static void testGet(final Subscriber<WeatherInfo> subscriber){
        RxHelper.setSubscribeToAndroidMainThread(getApiService().rxGetTest(), new CommonResponseSubscribe<WeatherInfo>() {
            @Override
            public void onNext(WeatherInfo weatherInfoBaseData) {
                subscriber.onNext(weatherInfoBaseData);
            }
        });
    }

    public static void testGet2(final Subscriber<WeatherInfo> subscriber){
        RxHelper.setSubscribeToAndroidMainThread(getApiService().rxGetTest(), new CommonResponseSubscribe<WeatherInfo>() {
            @Override
            public void onNext(WeatherInfo weatherInfoBaseData) {
                subscriber.onNext(weatherInfoBaseData);
            }
        });
    }

    public static void testPost(final Subscriber<BaseData<TestStrResult>> subscriber){
        Map<String, String> paramMap = new HashMap<>();
        RxHelper.handleCommonErrorsAndSetCallbackToMainThread(getApiService().rxPostTest(paramMap), new CommonResponseSubscribe<BaseData<TestStrResult>>() {

            @Override
            public void onNext(BaseData<TestStrResult> testStrResultBaseData) {

                subscriber.onNext(testStrResultBaseData);
            }
        });
    }







}
