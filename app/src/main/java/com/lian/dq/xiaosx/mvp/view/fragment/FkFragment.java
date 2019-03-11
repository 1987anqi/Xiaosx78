package com.lian.dq.xiaosx.mvp.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.lian.dq.xiaosx.R;
import com.lian.dq.xiaosx.adapter.RecyclerMoveAdapter;
import com.lian.dq.xiaosx.adapter.TabAdpter;
import com.lian.dq.xiaosx.adapter.YaowenAdpter;
import com.lian.dq.xiaosx.beans.Fen;
import com.lian.dq.xiaosx.mvp.Contract.FenLeiContract;
import com.lian.dq.xiaosx.mvp.Contract.ListNewsContract;
import com.lian.dq.xiaosx.mvp.presenter.FenLeiPresenter;
import com.lian.dq.xiaosx.mvp.view.MoveItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FkFragment extends Fragment implements FenLeiContract.IFenView{


    private TabLayout ywtb;
    private ViewPager ywvp;
    private FenLeiContract.IFenPresenter iFenPresenter;
    private List<Fragment> fragments;
    private List<Fen.ClassifyBean> fenbean = new ArrayList<>();
    private List<String> stringList;
    private TabAdpter adapter;
    private ImageView fang;
    private Window mWindow;
    private RecyclerView poprl;
    private Button btwc;
    private ListNewsContract.IListPresenter iListPresenter;
    private YaowenAdpter yaowenAdpter;

    public FkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fk, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ywtb = (TabLayout) view.findViewById(R.id.ywtb);
        ywvp = (ViewPager) view.findViewById(R.id.ywvp);


        fragments = new ArrayList<>();
        stringList = new ArrayList<>();
        adapter = new TabAdpter(getChildFragmentManager(), fragments, stringList);
        ywvp.setAdapter(adapter);
        ywvp.setCurrentItem(1);
        ywtb.setupWithViewPager(ywvp);

        //分类
        iFenPresenter = new FenLeiPresenter(this);
        iFenPresenter.getFen();

        //点击方块弹出popwindow
        fang = (ImageView) view.findViewById(R.id.fang);
        fang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击背景变暗
                mWindow = getActivity().getWindow();
                WindowManager.LayoutParams params = mWindow.getAttributes();
                params.alpha = 0.7f;
                mWindow.setAttributes(params);

                final View pop = LayoutInflater.from(getContext()).inflate(R.layout.pop,null);
                poprl = pop.findViewById(R.id.poprl);
                btwc = pop.findViewById(R.id.btwc);

                final PopupWindow popWindow = new PopupWindow(pop, 1090, 1500);

                popWindow.setFocusable(true);//获取焦点

                popWindow.setOutsideTouchable(true);      //必须设置背景 即使为null或者透明 否则点击外部不会消失
                popWindow.setBackgroundDrawable(null);
                popWindow.showAtLocation(pop, Gravity.BOTTOM, 0, 0);//相对于父控件的位置,可以设置偏移或无偏移


                //弹框消失恢复亮度
                popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        if(mWindow !=null){
                            WindowManager.LayoutParams params = mWindow.getAttributes();
                            params.alpha = 1.0f;
                            mWindow.setAttributes(params);
                        }
                    }

                });

                poprl.setLayoutManager(new GridLayoutManager(getContext(),4));
                poprl.setHasFixedSize(true);
                RecyclerMoveAdapter recyclerMoveAdapter = new RecyclerMoveAdapter(getContext());
                MoveItem moveItem = new MoveItem(recyclerMoveAdapter);
                recyclerMoveAdapter.setData(stringList);
                poprl.setAdapter(recyclerMoveAdapter);
                ItemTouchHelper helper = new ItemTouchHelper(moveItem);
                helper.attachToRecyclerView(poprl);


                btwc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popWindow.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void showFen(Fen fen) {

        List<Fen.ClassifyBean> classify = fen.getClassify();

        for (int i = 0; i < classify.size(); i++) {
            YaowenFragment yaowenFragment = new YaowenFragment();
            fragments.add(yaowenFragment);
            stringList.add(classify.get(i).getClassify_title());
        }

        fenbean.addAll(classify);
        adapter.notifyDataSetChanged();
    }
}
