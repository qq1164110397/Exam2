package com.example.exam2.net;

public interface INetCallBack<T> {
    public void onSuccess(T t);

    public void OnFail(String err);
}
