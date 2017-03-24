package com.kangkang.biubiubiu.fragment.tj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kangkang.biubiubiu.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/23 0023.
 */

public class CommunityViewPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<BaseFragment> fragments;
    private String[] haha =new String[]{"综合","动态"};

    public CommunityViewPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.fragments=fragments;

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
        return haha[position];
    }
}
