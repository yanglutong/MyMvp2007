package com.example.myapplication.loadfragments_demo.bean;

public class SendBean {
    private int id;
    private String cellid;
    private String lac;
    private String mnc;
    private String nid;
    private String sid;

    @Override
    public String toString() {
        return "SendBean{" +
                "cellid='" + cellid + '\'' +
                ", lac='" + lac + '\'' +
                ", mnc='" + mnc + '\'' +
                ", nid='" + nid + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }

    public SendBean(String cellid, String lac, String mnc, String nid, String sid) {
        this.cellid = cellid;
        this.lac = lac;
        this.mnc = mnc;
        this.nid = nid;
        this.sid = sid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCellid() {
        return cellid;
    }

    public void setCellid(String cellid) {
        this.cellid = cellid;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
