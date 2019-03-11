package com.lian.dq.xiaosx.mvp.Contract;

import com.lian.dq.xiaosx.beans.ListDemo;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;

public interface ListNewsContract {

    interface IListView{
        void showList(ListDemo listDemo);
    }
    interface IListModel{
        <T> void setList(NetWorkCallBack<T> callBack);
    }
    interface  IListPresenter{
        void getList();
    }

}
