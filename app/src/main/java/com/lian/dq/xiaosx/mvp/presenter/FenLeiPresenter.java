package com.lian.dq.xiaosx.mvp.presenter;

import android.util.Log;

import com.lian.dq.xiaosx.beans.Fen;
import com.lian.dq.xiaosx.mvp.Contract.FenLeiContract;
import com.lian.dq.xiaosx.mvp.moudle.FenLeiModel;
import com.lian.dq.xiaosx.utils.NetWorkCallBack;

public class FenLeiPresenter implements FenLeiContract.IFenPresenter {


    private FenLeiContract.IFenModel iFenModel;
    private FenLeiContract.IFenView iFenView;

    public FenLeiPresenter(FenLeiContract.IFenView iFenView) {
        this.iFenView = iFenView;
        iFenModel = new FenLeiModel();
    }

    @Override
    public void getFen() {
        iFenModel.setFen(new NetWorkCallBack<Fen>() {
            @Override
            public void onSuccess(Fen fen) {
                Log.e("分类数据",fen.getClassify().toString());
                iFenView.showFen(fen);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("分类错误数据",e.getMessage());
            }
        });
    }
}
