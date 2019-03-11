package com.lian.dq.xiaosx.mvp.moudle;

import com.lian.dq.xiaosx.mvp.Contract.ListNewsContract;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;
import com.lian.dq.xiaosx.utils.RetrofitUtils;
import com.lian.dq.xiaosx.utils.URLConstant;

public class ListNewsModel implements ListNewsContract.IListModel {
    @Override
    public <T> void setList(NetWorkCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(URLConstant.LIST_URL,callBack);
    }
}
