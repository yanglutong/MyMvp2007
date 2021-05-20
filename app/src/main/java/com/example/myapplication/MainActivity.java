package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplibrary.base.activity.BaseMvpActivity;
import com.example.mvplibrary.base.fragment.BaseMvpFragment;
import com.example.myapplication.loadfragments_demo.bean.LoadBean;
import com.example.myapplication.loadfragments_demo.bean.SendBean;
import com.example.myapplication.loadfragments_demo.constants.LoadFragmentConstants;
import com.example.myapplication.loadfragments_demo.model.LoadFragmentModel;
import com.example.myapplication.loadfragments_demo.presenter.LoadFragmentPresenter;

public class MainActivity extends BaseMvpActivity<LoadFragmentConstants.LoadView, LoadFragmentModel, LoadFragmentPresenter> implements LoadFragmentConstants.LoadView {

    @Override
    protected int createLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initMvpData() {
        getView();
    }

    @Override
    protected LoadFragmentPresenter createPresenter() {
        return new LoadFragmentPresenter();
    }

    private void getView() {
        Button homeFragment =  findViewById(R.id.bt_select);
        Button btCdma =  findViewById(R.id.btCdma);
        final EditText ed_cellid =  findViewById(R.id.ed_cellid);
        final EditText ed_lac =  findViewById(R.id.ed_lac);
        final EditText ed_mnc =  findViewById(R.id.ed_mnc);
        final EditText ed_nid =  findViewById(R.id.ed_nid);
        final EditText ed_sid =  findViewById(R.id.ed_sid);

        //
        btCdma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                //cdma
                SendBean sendBean = new SendBean(ed_cellid.getText().toString().trim(),
                        ed_lac.getText().toString().trim(),
                        ed_mnc.getText().toString(), ed_nid.getText().toString().trim(),
                        ed_sid.getText().toString().trim());
                sendBean.setId(0);
                mPresenter.getData(sendBean);
            }
        });

        homeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4g
                SendBean sendBean = new SendBean(ed_cellid.getText().toString().trim(),
                        ed_lac.getText().toString().trim(),
                        ed_mnc.getText().toString(), ed_nid.getText().toString().trim(),
                        ed_sid.getText().toString().trim());
                sendBean.setId(1);
                mPresenter.getData(sendBean);
            }
        });
    }

    @Override
    public void showLoadData(LoadBean s) {
        Toast.makeText(this, s.getAddr(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String s, int c) {
        Toast.makeText(this, ""+s+"-------"+c, Toast.LENGTH_SHORT).show();
    }
}