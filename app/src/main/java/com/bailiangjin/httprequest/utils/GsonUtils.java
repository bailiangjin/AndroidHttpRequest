package com.bailiangjin.httprequest.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Gson 工具类
 *
 * @author blj
 */
public class GsonUtils {
    private static Gson gson = new Gson();

    private GsonUtils() {

    }

//    public static <T> T toObj(String json) {
//        if (TextUtils.isEmpty(json) ) {
//            return null;
//        }
//            Type type = new TypeToken<T>() {}.getType();
//        return (T) gson.fromJson(json, type.getClass());
//    }

    public static <T> T toObj(String json, Class<T> clazz) {

        if (TextUtils.isEmpty(json) || null == clazz) {
            return null;
        }
        try {
            return gson.fromJson(json, clazz);
        }catch (Exception e){
            e.printStackTrace();
            LogUtils.e("服务端接口json数据格式异常:"+e.getMessage());
            return null;
        }

    }

    public static String toJson(Object obj) {
        if (null == obj) {
            return null;
        }
        return gson.toJson(obj);
    }


    /**
     * 将json array 字符串转换为  List
     *
     * @param listJsonStr json array 字符串
     * @return List<T>
     */
    public static <T extends Object> List<T> parsJsonArrayStr2List(String listJsonStr) {
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        List<T> list = gson.fromJson(listJsonStr, type);

        if (null != list) {
            return list;
        }
        return null;
    }

    public static Gson getGson() {
        return gson;
    }


}
