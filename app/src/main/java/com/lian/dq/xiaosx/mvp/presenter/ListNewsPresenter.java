package com.lian.dq.xiaosx.mvp.presenter;

import android.util.Log;

import com.lian.dq.xiaosx.beans.ListDemo;
import com.lian.dq.xiaosx.mvp.Contract.ListNewsContract;
import com.lian.dq.xiaosx.mvp.moudle.ListNewsModel;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;

public class ListNewsPresenter implements ListNewsContract.IListPresenter {

    private ListNewsContract.IListModel iListModel;
    private ListNewsContract.IListView iListView;

    public ListNewsPresenter(ListNewsContract.IListView iListView) {
        this.iListView = iListView;
        iListModel = new ListNewsModel();
    }

    @Override
    public void getList() {
        iListModel.setList(new NetWorkCallBack<ListDemo>() {
            @Override
            public void onSuccess(ListDemo listDemo) {
                Log.e("列表数据",listDemo.toString());
                iListView.showList(listDemo);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("列表错误数据",e.getMessage());
            }
        });
    }
}
