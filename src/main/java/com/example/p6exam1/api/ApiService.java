package com.example.p6exam1.api;

import com.example.p6exam1.beans.BannerBean;
import com.example.p6exam1.beans.ClassBean;
import com.example.p6exam1.beans.NavBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String bannerurl = "http://cdwan.cn:7000/exam2003/";
    String item1url = "http://cdwan.cn:7000/exam2003/";
    String item2url = "http://cdwan.cn:7000/exam2003/";

    @GET("abannerlist.json")
    Observable<BannerBean> bannerget();

    @GET("anewslist.json")
    Observable<NavBean> navitem();

    @GET("astudent.json")
    Observable<ClassBean> classitem();
}
