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
 * 网络请求服务提供者
 * Created by bailiangjin on 2017/2/15.
 */

public class RxOkServiceProvider{


    public static ApiService getWeatherApiService() {
        LogUtils.d("requestBaseUrl:"+WeatherApiService.INSTANCE.getBaseUrl());
        return WeatherApiService.INSTANCE.getApiService();
    }

    public static ApiService getExpressApiService() {
        LogUtils.d("requestBaseUrl:"+ ExpressApiService.INSTANCE.getBaseUrl());
        return ExpressApiService.INSTANCE.getApiService();
    }

    public static void testWeatherGet(final Subscriber<WeatherInfo> subscriber) {
        RxRequestHelper.requestNotDealCommonError(getWeatherApiService().rxGetTest(), new CommonResponseSubscriber<WeatherInfo>() {
            @Override
            public void onNext(WeatherInfo weatherInfoBaseData) {
                subscriber.onNext(weatherInfoBaseData);
            }
        });
    }

    public static void testExpressGet(final Subscriber<PostInfo> subscriber) {
        RxRequestHelper.requestNotDealCommonError(getExpressApiService().rxGetPostInfo(), new CommonResponseSubscriber<PostInfo>() {
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

    /**
     * post示例 不使用公有异常处理 post只写上了使用方式 具体测试请使用自己的接口测试
     * @param subscriber
     */
    public static void testPost1(final Subscriber<PostInfo> subscriber) {
        Map<String, String> paramMap = new HashMap<>();
        RxRequestHelper.requestNotDealCommonError(getWeatherApiService().rxPostTest1(paramMap), new CommonResponseSubscriber<PostInfo>() {
            @Override
            public void onNext(PostInfo postInfoBaseData) {

                subscriber.onNext(postInfoBaseData);
            }
        });
    }


    /**
     * post示例 使用公有异常处理 具体测试请使用自己的接口测试
     * @param subscriber
     */
    public static void testPost2(final Subscriber<BaseData<PostInfo>> subscriber) {
        Map<String, String> paramMap = new HashMap<>();
        RxRequestHelper.requestDealCommonError(getWeatherApiService().rxPostTest2(paramMap), new CommonResponseSubscriber<BaseData<PostInfo>>() {

            @Override
            public void onNext(BaseData<PostInfo> postInfoBaseData) {

                subscriber.onNext(postInfoBaseData);
            }
        });
    }


}
