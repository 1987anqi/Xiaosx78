package com.lian.dq.xiaosx.mvp.Contract;

import com.lian.dq.xiaosx.beans.LunBo;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;

public interface LunBoNewsContract {
    interface ILunBoView{
        void showLunBo(LunBo lunBo);
    }
    interface ILunBoModel{
        <T> void setLunBo(NetWorkCallBack<T> callBack);
    }
    interface  ILunBoPresenter{
        void getLunBo();
    }
}
