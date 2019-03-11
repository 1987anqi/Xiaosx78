package com.lian.dq.xiaosx.mvp.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lian.dq.xiaosx.R;
import com.lian.dq.xiaosx.adapter.YaowenAdpter;
import com.lian.dq.xiaosx.beans.ListDemo;
import com.lian.dq.xiaosx.beans.LunBo;
import com.lian.dq.xiaosx.mvp.Contract.ListNewsContract;
import com.lian.dq.xiaosx.mvp.Contract.LunBoNewsContract;
import com.lian.dq.xiaosx.mvp.presenter.ListNewsPresenter;
import com.lian.dq.xiaosx.mvp.presenter.LunBoNewsPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class YaowenFragment extends Fragment implements LunBoNewsContract.ILunBoView, ListNewsContract.IListView {


    private Banner banner;
    private LunBoNewsContract.ILunBoPresenter iLunBoPresenter;
    private List<String> images;
    private ListNewsContract.IListPresenter iListPresenter;
    private RecyclerView rl;
    private List<ListDemo.ImageListBean> listBeans;
    private YaowenAdpter yaowenAdpter;
    private boolean isShow = true;
    private TabLayout tb;

    public YaowenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yaowen, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        NestedScrollView nsc = view.findViewById(R.id.nsc);
        List<LunBo.BannerListBean> list = new ArrayList<>();
        images = new ArrayList<>();

        //把创建的数据传过来
        banner.setImages(list);
        banner.setDelayTime(2000);
        banner.isAutoPlay(true);

        //轮播图
        iLunBoPresenter = new LunBoNewsPresenter(this);
        iLunBoPresenter.getLunBo();

        rl = (RecyclerView) view.findViewById(R.id.rl);
        listBeans = new ArrayList<>();
        rl.setLayoutManager(new LinearLayoutManager(getContext()));
        rl.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        rl.setNestedScrollingEnabled(false);
        yaowenAdpter = new YaowenAdpter(listBeans,getContext());
        rl.setAdapter(yaowenAdpter);
        //列表
        iListPresenter = new ListNewsPresenter(this);
        iListPresenter.getList();



        tb = getActivity().findViewById(R.id.tb);

        nsc.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int i, int i1, int i2, int i3) {
                //上滑 并且正在显示底部栏
                if (i1-i3>0 && isShow){
                    isShow=false;
                    //将Y实行变成底部栏高度
//                    tb.animate().translationY(tb.getHeight());
                    tb.setVisibility(View.GONE);
                }else if (i1-i3<0 && !isShow){
                    isShow=true;
//                    tb.animate().translationY(0);
                    tb.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public void showLunBo(LunBo lunBo) {
        List<LunBo.BannerListBean> banner_list = lunBo.getBanner_list();
        List<String> imgList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();

        for (int i = 0; i < banner_list.size(); i++) {
            imgList.add(banner_list.get(i).getBanner_url());
            titleList.add(banner_list.get(i).getBanner_date());

        }
        banner.setImages(images);
        //装填器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(getActivity()).load(path).into(imageView);
            }
        });
        banner.setImages(imgList);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setBannerAnimation(Transformer.Default);
        banner.setBannerTitles(titleList);
        banner.setDelayTime(1000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
        banner.start();
    }

    @Override
    public void showList(ListDemo listDemo) {
        List<ListDemo.ImageListBean> image_list = listDemo.getImage_list();
        listBeans.addAll(image_list);
        yaowenAdpter.notifyDataSetChanged();
    }
}
