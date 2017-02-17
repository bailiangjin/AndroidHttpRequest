package com.bailiangjin.httprequest.net.rxretrofitokhttp.design;

import com.bailiangjin.httprequest.utils.ToastUtils;

import rx.Subscriber;

/**
 * Created by bailiangjin on 2017/2/16.
 */

public abstract class CommonResponseSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();

        ToastUtils.shortToast("异常提示:" + e.getMessage());
    }

}
