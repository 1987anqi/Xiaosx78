package com.lian.dq.xiaosx.mvp.moudle;

import com.lian.dq.xiaosx.mvp.Contract.LunBoNewsContract;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;
import com.lian.dq.xiaosx.utils.RetrofitUtils;
import com.lian.dq.xiaosx.utils.URLConstant;

public class LunBoNewsModel implements LunBoNewsContract.ILunBoModel {
    @Override
    public <T> void setLunBo(NetWorkCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(URLConstant.BANNER_URL,callBack);
    }
}
