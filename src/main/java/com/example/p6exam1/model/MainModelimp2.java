package com.example.p6exam1.model;

import com.example.p6exam1.api.ApiService;
import com.example.p6exam1.beans.BannerBean;
import com.example.p6exam1.beans.ClassBean;
import com.example.p6exam1.beans.NavBean;
import com.example.p6exam1.concate.Concate;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModelimp2 {

    public void getData(Concate.CallBack2 callBack) {

        new Retrofit.Builder().baseUrl(ApiService.item1url)
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .navitem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NavBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull NavBean navBean) {
                callBack.OnScuress2(navBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                callBack.OnFail2(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
