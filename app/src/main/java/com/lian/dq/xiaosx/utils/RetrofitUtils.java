package com.lian.dq.xiaosx.utils;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements INetWork {

    private static RetrofitUtils retrofitUtils;

    private MyApiService apiService;

    public RetrofitUtils() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(URLConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(MyApiService.class);


    }

    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }


    @Override
    public <T> void get(String url, final NetWorkCallBack<T> callBak) {
        apiService.get(url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseBody responseBody) {
//                        解析
//                        第一步获取 泛型对象
                        fromJson(responseBody,callBak);
                        Log.e("++++get",responseBody.toString());
                    }
                    @Override
                    public void onError(Throwable e) {
                        callBak.onError(e);
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public <T> void get(String url, Map<String, String> map, final NetWorkCallBack<T> callBak) {
        apiService.get(url,map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        fromJson(responseBody,callBak);
                        Log.e("++++gett",responseBody.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private <T> void fromJson(ResponseBody responseBody,NetWorkCallBack<T> callBak){

        Type[] genericInterfaces = callBak.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
        Type actualTypeArgument = actualTypeArguments[0];
        Gson gson = new Gson();
        try {
            T result = gson.fromJson(responseBody.string(), actualTypeArgument);
            callBak.onSuccess(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
