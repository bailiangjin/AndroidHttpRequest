package com.bailiangjin.httprequest.rxokdemo.model;

import java.util.List;

/**
 * Created by bailiangjin on 2017/2/17.
 */

public class PostInfo {


    /**
     * message : ok
     * nu : 200382770316
     * ischeck : 1
     * condition : F00
     * com : yuantong
     * status : 200
     * state : 3
     * data : [{"time":"2016-08-18 12:09:58","ftime":"2016-08-18 12:09:58","context":"客户 签收人 :本人签收 已签收 感谢使用圆通速递，期待再次为您服务","location":null},{"time":"2016-08-18 08:48:25","ftime":"2016-08-18 08:48:25","context":"贵州省安顺市公司(点击查询电话)鲁** 派件中 派件员电话18608533669","location":null},{"time":"2016-08-18 06:01:24","ftime":"2016-08-18 06:01:24","context":"贵州省安顺市公司 已收入","location":null},{"time":"2016-08-17 11:37:03","ftime":"2016-08-17 11:37:03","context":"贵阳转运中心 已发出,下一站 贵州省安顺市","location":null},{"time":"2016-08-17 11:32:25","ftime":"2016-08-17 11:32:25","context":"贵阳转运中心 已收入","location":null},{"time":"2016-08-16 00:42:43","ftime":"2016-08-16 00:42:43","context":"北京转运中心 已收入","location":null},{"time":"2016-08-16 00:42:30","ftime":"2016-08-16 00:42:30","context":"北京转运中心 已发出,下一站 贵阳转运中心","location":null},{"time":"2016-08-15 22:59:02","ftime":"2016-08-15 22:59:02","context":"北京市西城区广安门公司 已打包","location":null},{"time":"2016-08-15 20:25:54","ftime":"2016-08-15 20:25:54","context":"北京市西城区广安门公司(点击查询电话) 已揽收","location":null}]
     */

    private String message;
    private String nu;
    private String ischeck;
    private String condition;
    private String com;
    private String status;
    private String state;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * time : 2016-08-18 12:09:58
         * ftime : 2016-08-18 12:09:58
         * context : 客户 签收人 :本人签收 已签收 感谢使用圆通速递，期待再次为您服务
         * location : null
         */

        private String time;
        private String ftime;
        private String context;
        private Object location;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getFtime() {
            return ftime;
        }

        public void setFtime(String ftime) {
            this.ftime = ftime;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }
    }
}
