package com.example.p6exam1.presenter;

import com.example.p6exam1.beans.BannerBean;
import com.example.p6exam1.beans.ClassBean;
import com.example.p6exam1.beans.NavBean;
import com.example.p6exam1.concate.Concate;
import com.example.p6exam1.model.MainModelimp;
import com.example.p6exam1.model.MainModelimp2;
import com.example.p6exam1.model.MainModelimp3;

public class MainPresenterimp {
    private final MainModelimp mainModelimp;
    private Concate.MainView mainView;

    public MainPresenterimp(Concate.MainView mainView) {
        this.mainView = mainView;
        mainModelimp = new MainModelimp();
    }

    public void getData() {
        mainModelimp.getData(new Concate.CallBack() {
            @Override
            public void OnScuress(BannerBean bannerBean) {
                mainView.OnScuress(bannerBean);
            }

            @Override
            public void OnFail(String error) {
                mainView.OnFail(error);
            }
        });
    }
}
