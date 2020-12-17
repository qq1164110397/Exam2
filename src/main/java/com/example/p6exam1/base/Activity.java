package com.example.p6exam1.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class Activity<T> extends AppCompatActivity {
    private T asdf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getID());
        if (asdf==null){
            asdf=get();
        }
        initData();
        initView();
    }

    protected abstract int getID();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract T get();

}
