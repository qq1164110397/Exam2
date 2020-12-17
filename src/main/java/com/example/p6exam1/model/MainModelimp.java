package com.example.p6exam1.model;

import android.util.AndroidRuntimeException;

import com.example.p6exam1.api.ApiService;
import com.example.p6exam1.beans.BannerBean;
import com.example.p6exam1.beans.ClassBean;
import com.example.p6exam1.beans.NavBean;
import com.example.p6exam1.concate.Concate;

import io.reactivex.Observer;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModelimp {

    public void getData(Concate.CallBack callBack) {
        new Retrofit.Builder().baseUrl(ApiService.bannerurl)
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class).bannerget().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BannerBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull BannerBean bannerBean) {
                callBack.OnScuress(bannerBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                callBack.OnFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
