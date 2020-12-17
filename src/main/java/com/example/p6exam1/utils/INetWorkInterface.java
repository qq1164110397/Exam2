package com.example.p6exam1.utils;

public interface INetWorkInterface {

    public <T> void get(String url,INetCallBack<T> callBack);

}
