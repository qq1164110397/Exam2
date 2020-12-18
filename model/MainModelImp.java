package com.example.exam2.model;

import com.example.exam2.concate.Concate;
import com.example.exam2.net.INetCallBack;
import com.example.exam2.net.RetrofitUtil;

import retrofit2.Retrofit;

public class MainModelImp implements Concate.IMainModel {

    private Concate.IMainPresrent presrent;

    @Override
    public <T> void getLoginData(String url, INetCallBack<T> callBack) {
        RetrofitUtil.getInstance().get(url,callBack);
    }
}
