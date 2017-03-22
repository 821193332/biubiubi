package com.kangkang.biubiubiu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kangkang.biubiubiu.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/21 0021.
 */

public class MainAdapter extends FragmentPagerAdapter{
    private final ArrayList<BaseFragment> fragments;
    private String[] titles = new String[]{"直播", "推荐","追番", "分区","发现"};

    public MainAdapter(FragmentManager fm, ArrayList<BaseFragment>fragments) {
        super(fm);
        this.fragments =fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
