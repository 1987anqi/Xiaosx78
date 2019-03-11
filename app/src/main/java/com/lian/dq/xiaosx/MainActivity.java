package com.lian.dq.xiaosx;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lian.dq.xiaosx.adapter.TabAdpter;
import com.lian.dq.xiaosx.mvp.view.fragment.HangFragment;
import com.lian.dq.xiaosx.mvp.view.fragment.FkFragment;
import com.lian.dq.xiaosx.mvp.view.fragment.KuaiXUnFragment;
import com.lian.dq.xiaosx.mvp.view.fragment.VipFragment;
import com.lian.dq.xiaosx.mvp.view.fragment.WodeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FkFragment());
        fragments.add(new KuaiXUnFragment());
        fragments.add(new VipFragment());
        fragments.add(new HangFragment());
        fragments.add(new WodeFragment());

        ArrayList<String> strings = new ArrayList<>();
        strings.add("见闻");
        strings.add("快讯");
        strings.add("Vip");
        strings.add("行情");
        strings.add("我的");

        vp = (ViewPager) findViewById(R.id.vp);
        tb = (TabLayout) findViewById(R.id.tb);

        TabAdpter adapter = new TabAdpter(getSupportFragmentManager(),fragments,strings);
        vp.setAdapter(adapter);

        tb.setupWithViewPager(vp);

    }
}
