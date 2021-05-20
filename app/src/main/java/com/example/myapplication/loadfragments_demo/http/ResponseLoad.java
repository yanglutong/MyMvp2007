package com.example.myapplication.loadfragments_demo.http;

import com.google.gson.JsonElement;

public class ResponseLoad {
    private String status;
    private String msg;
    private JsonElement result;

    public ResponseLoad(String status, String msg, JsonElement result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseLoad{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonElement getResult() {
        return result;
    }

    public void setResult(JsonElement result) {
        this.result = result;
    }
}
