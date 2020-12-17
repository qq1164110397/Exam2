package com.example.p6exam1.utils;

public interface INetCallBack <T> {
    public void OnSuccess(T t);
    public void OnFail(String error);
}
