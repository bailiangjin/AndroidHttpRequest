package com.bailiangjin.httprequest.rxokdemo;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.BaseData;
import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.CommonResponseSubscriber;
import com.bailiangjin.httprequest.net.rxretrofitokhttp.tools.RxRequestHelper;
import com.bailiangjin.httprequest.rxokdemo.model.PostInfo;
import com.bailiangjin.httprequest.rxokdemo.model.WeatherInfo;
import com.bailiangjin.httprequest.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;


/**
 * Created by bailiangjin on 2017/2/15.
 */

public class RxOkServiceProvider{


    public static ApiService getWeatherApiService() {
        LogUtils.d("requestBaseUrl:"+WeatherApiService.INSTANCE.getBaseUrl());
        return WeatherApiService.INSTANCE.getApiService();
    }

    public static ApiService getPostApiService() {
        LogUtils.d("requestBaseUrl:"+PostApiService.INSTANCE.getBaseUrl());
        return PostApiService.INSTANCE.getApiService();
    }

    public static void testWeatherGet(final Subscriber<WeatherInfo> subscriber) {
        RxRequestHelper.requestNotDealCommonError(getWeatherApiService().rxGetTest(), new CommonResponseSubscriber<WeatherInfo>() {
            @Override
            public void onNext(WeatherInfo weatherInfoBaseData) {
                subscriber.onNext(weatherInfoBaseData);
            }
        });
    }

    public static void testPostGet(final Subscriber<PostInfo> subscriber) {
        RxRequestHelper.requestNotDealCommonError(getPostApiService().rxGetPostInfo(), new CommonResponseSubscriber<PostInfo>() {
            @Override
            public void onNext(PostInfo weatherInfoBaseData) {
                subscriber.onNext(weatherInfoBaseData);
            }
        });
    }

    public static void testGet2(final Subscriber<WeatherInfo> subscriber) {
        RxRequestHelper.requestNotDealCommonError(getWeatherApiService().rxGetTest(), new CommonResponseSubscriber<WeatherInfo>() {
            @Override
            public void onNext(WeatherInfo weatherInfoBaseData) {
                subscriber.onNext(weatherInfoBaseData);
            }
        });
    }

    public static void testPost(final Subscriber<BaseData<PostInfo>> subscriber) {
        Map<String, String> paramMap = new HashMap<>();
        RxRequestHelper.requestDealCommonError(getWeatherApiService().rxPostTest(paramMap), new CommonResponseSubscriber<BaseData<PostInfo>>() {

            @Override
            public void onNext(BaseData<PostInfo> postInfoBaseData) {

                subscriber.onNext(postInfoBaseData);
            }
        });
    }


}
