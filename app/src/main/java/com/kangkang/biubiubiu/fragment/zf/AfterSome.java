package com.kangkang.biubiubiu.fragment.zf;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/21 0021.
 */

public class AfterSome extends BaseFragment {
    @InjectView(R.id.rv_home)
    RecyclerView rvHome;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.zhui_fan, null);
        ButterKnife.inject(this,view);
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
