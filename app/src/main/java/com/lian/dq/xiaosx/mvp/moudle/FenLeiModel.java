package com.lian.dq.xiaosx.mvp.moudle;

import com.lian.dq.xiaosx.mvp.Contract.FenLeiContract;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;
import com.lian.dq.xiaosx.utils.RetrofitUtils;
import com.lian.dq.xiaosx.utils.URLConstant;

public class FenLeiModel implements FenLeiContract.IFenModel {
    @Override
    public <T> void setFen(NetWorkCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(URLConstant.FEN_URL,callBack);
    }
}
