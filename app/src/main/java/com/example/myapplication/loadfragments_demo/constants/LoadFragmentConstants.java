package com.example.myapplication.loadfragments_demo.constants;

import com.example.mvplibrary.base.model.ModelBaseCallBack;
import com.example.mvplibrary.base.view.BaseView;

import com.example.myapplication.loadfragments_demo.bean.LoadBean;
import com.example.myapplication.loadfragments_demo.bean.SendBean;
import com.trello.rxlifecycle2.LifecycleProvider;

public interface LoadFragmentConstants {
    //创建三层之间的接口
    interface LoadView extends BaseView {
        void showLoadData(LoadBean s);
        void showError(String s, int c);
    }
    interface LoadPresenter{
        void getData(SendBean sendBean);
    }
    interface LoadModel{
        void getLoadModel(SendBean sendBean, ModelBaseCallBack<LoadBean> modelBaseCallBack, LifecycleProvider lifecycleProvider);
    }
}
