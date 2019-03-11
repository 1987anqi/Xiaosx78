package com.lian.dq.xiaosx.mvp.Contract;

import com.lian.dq.xiaosx.beans.Fen;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;

public interface FenLeiContract {

    interface IFenView{
        void showFen(Fen fen);
    }
    interface IFenModel{
        <T> void setFen(NetWorkCallBack<T> callBack);
    }
    interface  IFenPresenter{
        void getFen();
    }

}
