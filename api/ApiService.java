package com.example.exam2.api;

import com.example.exam2.beans.ListBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {
//    String urlbase = "http://cdwan.cn:7000/exam2003/anewslist.json";
    @GET
    Observable<ListBean> get(@Url String url);

    @POST
    @FormUrlEncoded
    Observable<ListBean> post(@Url String url);

    @POST
    @FormUrlEncoded
    Observable<ListBean> post(@Url String url, @FieldMap HashMap<String,String> map);
}
