package com.kangkang.biubiubiu.fragment.tj;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.base.BaseFragment;
import com.kangkang.biubiubiu.fragment.tj.adapter.CommunityViewPagerAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/21 0021.
 */

public class Recommend extends BaseFragment {
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;

    private ArrayList<BaseFragment> fragments;
    private CommunityViewPagerAdapter adapter;

    @Override
    public View initView() {

        View view = View.inflate(mContext, R.layout.fragment_recommend, null);
        Log.e("TAG", "get1111111====");
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e("TAG", "get333333333====");
        initFragment();
        adapter = new CommunityViewPagerAdapter(getChildFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);


    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ComprehensiveFragments());//综合
        fragments.add(new DynamicFragments());//动态
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
