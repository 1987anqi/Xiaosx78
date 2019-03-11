package com.lian.dq.xiaosx.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabAdpter extends FragmentPagerAdapter {

    List<Fragment> fragments;
    List<String> stringList;

    public TabAdpter(FragmentManager fm, List<Fragment> fragments, List<String> stringList) {
        super(fm);
        this.fragments = fragments;
        this.stringList = stringList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
