package com.bailiangjin.httprequest.net.rxretrofitokhttp.tools;

import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.BaseData;
import com.bailiangjin.httprequest.net.rxretrofitokhttp.design.CommonErrors;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bailiangjin on 2017/2/16.
 */

public class RxHelper {


    /**
     * rx 回调到mainThread
     * @param observable
     * @param subscriber
     * @param <T>
     */
    public static <T> void setSubscribeToAndroidMainThread(Observable<T> observable, Subscriber<T> subscriber) {

        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 异常统一处理
     * @param observable
     * @param <T>
     */
    private static <T> void mapCommonErrors(Observable<BaseData<T>> observable) {
        observable.map(new CommonErrors<T>());
    }


    /**
     * 异常处理 回调到Main Thread
     * @param observable
     * @param subscriber
     * @param <T>
     * @return
     */
    public static <T> Observable handleCommonErrorsAndSetCallbackToMainThread(Observable<BaseData<T>> observable, Subscriber<BaseData<T>> subscriber) {
        mapCommonErrors(observable);
        setSubscribeToAndroidMainThread(observable, subscriber);
        return observable;
    }


}
