package com.example.myapplication.loadfragments_demo.bean;

public class LoadBean {

    /**
     * lat : 39.65280914
     * lng : 115.93230438
     * addr : 北京市房山区周口店地区城一锅(房宜路),新街路与房易路路口东南409.97米
     * accuracy : 500
     */

    private String lat;
    private String lng;
    private String addr;
    private int accuracy;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
