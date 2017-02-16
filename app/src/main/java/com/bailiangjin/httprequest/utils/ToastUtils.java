package com.bailiangjin.httprequest.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.bailiangjin.httprequest.MyApplication;

/**
 * Toast 工具类
 *
 * @author 白良锦
 *
 * 2016-09-14
 */
public class ToastUtils {

    private ToastUtils() {
        throw new UnsupportedOperationException("ToastUtils cannot be instantiated");
    }

    /**
     * 短提示 by resId
     *
     * @param resId
     */
    public static void shortToast(int resId) {
        toastResId( resId, Toast.LENGTH_SHORT);
    }

    /**
     * 短提示 by String
     *
     * @param string
     */
    public static void shortToast(String string) {
        toastString(string, Toast.LENGTH_SHORT);
    }

    /**
     * 长提示 by resId
     *
     * @param resId
     */
    public static void longToast(int resId) {
        toastResId(resId, Toast.LENGTH_LONG);
    }

    /**
     * 常提示 by String
     *
     * @param string
     */
    public static void longToast(String string) {
        toastString(string, Toast.LENGTH_LONG);
    }

    private static Handler h=new Handler(Looper.getMainLooper());
    /**
     * 判断时间间隔提示Toast by String
     *
     * @param str      文字
     * @param showTime
     */
    private static void toastString(final String str, final int showTime) {
        h.post(new Runnable() {
            @Override
            public void run() {
                MyToast.getToast(MyApplication.getAppContext(), str, showTime).show();
            }
        });
    }

    /**
     * 判断时间间隔提示Toast by resId
     * @param resId
     * @param showTime
     */
    private static void toastResId(int resId, int showTime) {
        toastString(MyApplication.getAppContext().getString(resId), showTime);
    }

    /**
     * 自定义Toast类
     *
     * @author blj
     */
    private static class MyToast {
        private static Toast toast = null;

        public static Toast getToast(Context context, String words, int showTime) {
            if (toast!=null) {
                toast.setText(words);
                toast.setDuration(showTime);
            } else {
                toast = Toast.makeText(context, words, showTime);
            }
            return toast;
        }
    }
}