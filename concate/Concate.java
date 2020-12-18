package com.example.exam2.concate;

import com.example.exam2.base.BaseView;
import com.example.exam2.beans.ListBean;
import com.example.exam2.net.INetCallBack;

public class Concate {
    public interface IMainModel{
        <T>void getLoginData(String url, INetCallBack<T> callBack);
    }

    public interface IMainPresrent{
        void show(ListBean listBean);

        void hide(String result);
    }

    public interface IMainView extends BaseView {
        void getData(ListBean listBean);
    }
}
