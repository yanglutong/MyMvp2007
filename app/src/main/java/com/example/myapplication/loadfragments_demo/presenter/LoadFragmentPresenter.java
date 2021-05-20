package com.example.myapplication.loadfragments_demo.presenter;


import com.example.mvplibrary.base.model.ModelBaseCallBack;
import com.example.mvplibrary.base.presenter.BasePresenterIml;
import com.example.myapplication.loadfragments_demo.bean.LoadBean;
import com.example.myapplication.loadfragments_demo.bean.SendBean;
import com.example.myapplication.loadfragments_demo.constants.LoadFragmentConstants;
import com.example.myapplication.loadfragments_demo.model.LoadFragmentModel;

public class LoadFragmentPresenter extends BasePresenterIml<LoadFragmentConstants.LoadView, LoadFragmentModel> implements LoadFragmentConstants.LoadPresenter, ModelBaseCallBack<LoadBean> {

    @Override
    public void getData(SendBean sendBean) {
        getModel().getLoadModel(sendBean,this,getLifecycleProvider());
    }


    @Override
    public void onSuccess(LoadBean data) {
        getView().showLoadData(data);
    }

    @Override
    public void onError(String msg, int code) {
        getView().showError(msg,code);
    }
}
