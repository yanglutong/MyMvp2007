package com.example.myapplication.loadfragments_demo.model;

import com.example.mvplibrary.base.model.BaseModel;

import com.example.mvplibrary.base.model.ModelBaseCallBack;
import com.example.myapplication.loadfragments_demo.bean.LoadBean;
import com.example.myapplication.loadfragments_demo.bean.SendBean;
import com.example.myapplication.loadfragments_demo.constants.LoadFragmentConstants;
import com.example.myapplication.loadfragments_demo.http.LoadHttpCallBack;
import com.google.gson.JsonElement;
import com.http.httplibrary.client.HttpClient;
import com.http.httplibrary.utils.JsonUtils;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.Map;

public class LoadFragmentModel extends BaseModel implements LoadFragmentConstants.LoadModel {

    @Override
    public void getLoadModel(SendBean sendBean, ModelBaseCallBack<LoadBean> modelBaseCallBack, LifecycleProvider lifecycleProvider) {
        getHttp(sendBean,modelBaseCallBack, lifecycleProvider);
//        postHttp(sendBean,modelBaseCallBack, lifecycleProvider);
    }

    private void postHttp(SendBean sendBean, final ModelBaseCallBack<LoadBean> modelBaseCallBack, LifecycleProvider lifecycleProvider) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        map.put("Authorization", "APPCODE eb358bdc0f28475e95ccbe24eb2e5ee7");
        params.put("cellid",sendBean.getCellid());
        params.put("lac",sendBean.getLac());
        params.put("mnc",sendBean.getMnc());
        new HttpClient.Buidler().post().
                setLifecycleProvider(lifecycleProvider)
                .setBaseUrl("http://jisujizhan.market.alicloudapi.com")
                .setApiUrl("/cell/query")
                .setHeadres(map)
                .setParamser(params)
                .build().enqueue(new LoadHttpCallBack<LoadBean>() {
            @Override
            public void error(String error, int code) {
                modelBaseCallBack.onError(error, code);
            }

            @Override
            public LoadBean convert(JsonElement result) {
                return JsonUtils.jsonToClass(result, LoadBean.class);
            }

            @Override
            public void onSuccess(LoadBean loadBean) {
                modelBaseCallBack.onSuccess(loadBean);
            }
        });
    }

    private void getHttp(SendBean sendBean, final ModelBaseCallBack<LoadBean> modelBaseCallBack, LifecycleProvider lifecycleProvider) {
        Map<String, Object> map = new HashMap<>();
        map.put("Authorization", "APPCODE eb358bdc0f28475e95ccbe24eb2e5ee7");
        Map<String, Object> params = new HashMap<>();
        if(sendBean.getId()==0){
            params.put("cellid",sendBean.getCellid());
            params.put("nid",sendBean.getNid());
            params.put("sid",sendBean.getSid());
        }
        else if(sendBean.getId()==1){
            params.put("cellid",sendBean.getCellid());
            params.put("lac",sendBean.getLac());
            params.put("mnc",sendBean.getMnc());
        }

        new HttpClient.Buidler().get().
                setLifecycleProvider(lifecycleProvider)
                .setBaseUrl("https://jisujizhan.market.alicloudapi.com")
                .setApiUrl("/cell/query")
                .setHeadres(map)
                .setParamser(params)
                .build().enqueue(new LoadHttpCallBack<LoadBean>() {
            @Override
            public void error(String error, int code) {
                modelBaseCallBack.onError(error, code);
            }

            @Override
            public LoadBean convert(JsonElement result) {
                return JsonUtils.jsonToClass(result, LoadBean.class);
            }

            @Override
            public void onSuccess(LoadBean loadBean) {
                modelBaseCallBack.onSuccess(loadBean);
            }
        });
    }
}
