package com.example.exam2.net;

import com.example.exam2.api.ApiService;
import com.example.exam2.beans.ListBean;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil implements INetWorkInterface{

    private static RetrofitUtil retrofitUtil;

    private ApiService apiService;

    public RetrofitUtil() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

        Retrofit build = new Retrofit.Builder()
                .baseUrl(URLconstant.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = build.create(ApiService.class);

    }

    public static RetrofitUtil getInstance() {
        if (retrofitUtil == null){
            synchronized (RetrofitUtil.class){
                if (retrofitUtil == null){
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }

    @Override
    public <T> void get(String url, INetCallBack<T> callBack) {
        apiService.get(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ListBean listBean) {
                        List<ListBean.NewsBean> news = listBean.getNews();

                        Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();

                        Type t = actualTypeArguments[0];

                        Gson gson = new Gson();
                        T result = gson.fromJson(String.valueOf(news),t);
                        callBack.onSuccess(result);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, INetCallBack<T> callBack) {
        apiService.post(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ListBean listBean) {
                        List<ListBean.NewsBean> news = listBean.getNews();

                        Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();

                        Type t = actualTypeArguments[0];

                        Gson gson = new Gson();
                        T result = gson.fromJson(String.valueOf(news),t);
                        callBack.onSuccess(result);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, INetCallBack<T> callBack) {
        apiService.post(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ListBean listBean) {
                        List<ListBean.NewsBean> news = listBean.getNews();

                        Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

                        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();

                        Type t = actualTypeArguments[0];

                        Gson gson = new Gson();
                        T result = gson.fromJson(String.valueOf(news),t);
                        callBack.onSuccess(result);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
