package com.lian.dq.xiaosx.utils;

public interface NetWorkCallBack<T> {
    void onSuccess(T t);
    void onError(Throwable e);
}
