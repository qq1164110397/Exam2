package com.example.p6exam1.concate;

import com.example.p6exam1.beans.BannerBean;
import com.example.p6exam1.beans.ClassBean;
import com.example.p6exam1.beans.NavBean;

public interface Concate {

    public interface MainView{
        void OnScuress(BannerBean bannerBean);
        void OnFail(String error);
    }

    public interface MainView2{
        void OnScuress2(NavBean navBean);
        void OnFail2(String error);
    }

    public interface MainView3{
        void OnScuress3(ClassBean classBean);
        void OnFail3(String error);
    }

    public interface CallBack{
        void OnScuress(BannerBean bannerBean);
        void OnFail(String error);
    }

    public interface CallBack2{
        void OnScuress2(NavBean navBean);
        void OnFail2(String error);
    }

    public interface CallBack3{
        void OnScuress3(ClassBean classBean);
        void OnFail3(String error);
    }
}
