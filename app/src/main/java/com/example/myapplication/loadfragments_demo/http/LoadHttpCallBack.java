package com.example.myapplication.loadfragments_demo.http;

import com.google.gson.JsonElement;
import com.http.httplibrary.callback.BaseCallBack;
import com.http.httplibrary.utils.JsonUtils;

public abstract class LoadHttpCallBack<T> extends BaseCallBack<T> {
    ResponseLoad response;
    @Override
    protected T onConvert(String result) {
        T t = null;
        response = JsonUtils.jsonToClass(result, ResponseLoad.class);
        JsonElement data = response.getResult();
        int status = Integer.parseInt(response.getStatus());
        String message = response.getMsg();
        switch (status){
            case 201://错误信息
            case 202:
            case 210:
                error(message,status);
                break;
            case 0:
                t=convert(data);
                break;
        }
        return t;
    }

    @Override
    public boolean isCodeSuccess() {
        return Integer.parseInt(response.getStatus())==0;
    }

}
