package com.example.exam2.base;

import com.example.exam2.base.BaseView;

public class BasePresenter<V extends BaseView> {
    public V iview;

    public void attachView(V v){
        iview = v;
    }
}
