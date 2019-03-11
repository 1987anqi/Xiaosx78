package com.lian.dq.xiaosx.mvp.presenter;

import android.util.Log;

import com.lian.dq.xiaosx.beans.LunBo;
import com.lian.dq.xiaosx.mvp.Contract.LunBoNewsContract;
import com.lian.dq.xiaosx.mvp.moudle.LunBoNewsModel;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;

public class LunBoNewsPresenter implements LunBoNewsContract.ILunBoPresenter {

    private LunBoNewsContract.ILunBoModel iLunBoModel;
    private LunBoNewsContract.ILunBoView iLunBoView;

    public LunBoNewsPresenter(LunBoNewsContract.ILunBoView iLunBoView) {
        this.iLunBoView = iLunBoView;
        iLunBoModel = new LunBoNewsModel();
    }

    @Override
    public void getLunBo() {
        iLunBoModel.setLunBo(new NetWorkCallBack<LunBo>() {
            @Override
            public void onSuccess(LunBo lunbo) {
                Log.e("轮播图数据",lunbo.getBanner_list().toString());
                iLunBoView.showLunBo(lunbo);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("轮播图错误数据",e.getMessage());
            }
        });
    }
}
