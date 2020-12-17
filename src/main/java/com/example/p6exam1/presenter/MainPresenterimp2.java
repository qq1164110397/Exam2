package com.example.p6exam1.presenter;

import android.util.Log;

import com.example.p6exam1.beans.NavBean;
import com.example.p6exam1.concate.Concate;
import com.example.p6exam1.model.MainModelimp2;

public class MainPresenterimp2 {
    private Concate.MainView2 mainView2;
    private final MainModelimp2 mainModelimp2;

    public MainPresenterimp2(Concate.MainView2 mainView2) {
        this.mainView2 = mainView2;
        mainModelimp2 = new MainModelimp2();
    }


    public void getData() {
        mainModelimp2.getData(new Concate.CallBack2() {
            @Override
            public void OnScuress2(NavBean navBean) {
                mainView2.OnScuress2(navBean);
            }

            @Override
            public void OnFail2(String error) {
                mainView2.OnFail2(error);
            }
        });
    }
}
