package com.example.p6exam1.presenter;

import com.example.p6exam1.beans.ClassBean;
import com.example.p6exam1.concate.Concate;
import com.example.p6exam1.model.MainModelimp3;

public class MainPresenterimp3 {
    private Concate.MainView3 mainView3;
    private final MainModelimp3 mainModelimp3;

    public MainPresenterimp3(Concate.MainView3 mainView3) {
        this.mainView3 = mainView3;
        mainModelimp3 = new MainModelimp3();
    }

    public void getData() {
        mainModelimp3.getData(new Concate.CallBack3() {
            @Override
            public void OnScuress3(ClassBean classBean) {
                mainView3.OnScuress3(classBean);
            }

            @Override
            public void OnFail3(String error) {
                mainView3.OnFail3(error);
            }
        });
    }
}
