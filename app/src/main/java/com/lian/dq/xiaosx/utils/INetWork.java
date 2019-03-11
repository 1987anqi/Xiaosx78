package com.lian.dq.xiaosx.utils;

import java.util.Map;

public interface INetWork {
    <T> void get(String url, NetWorkCallBack<T> callBak);

    <T> void get(String url, Map<String, String> map, NetWorkCallBack<T> callBak);

}
