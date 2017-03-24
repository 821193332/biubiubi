package com.kangkang.biubiubiu.fragment.tj;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.base.BaseFragment;
import com.kangkang.biubiubiu.fragment.tj.adapter.CommunityViewAdapter;
import com.kangkang.biubiubiu.fragment.tj.bean.Comprehensive;
import com.kangkang.biubiubiu.utils.Network;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/23 0023.
 */

public class ComprehensiveFragments extends BaseFragment {


    @InjectView(R.id.rv_home)
    RecyclerView rvHome;
      private CommunityViewAdapter adapter;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.zonghe, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e("TAG", "综合页面数据被初始化了...");
        getZongHe();
    }

    private void getZongHe() {
        OkHttpUtils.get().url(Network.ZHONGHE_URL).id(100)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("TAG", "推荐页面综合联网失败==" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("TAG", "推荐页面综合联网成功==");
                ProcessedDat(response);
            }
        });
    }

    private void ProcessedDat(String response) {
        Comprehensive comprehensive = JSON.parseObject(response, Comprehensive.class);
        Log.e("TAG", "解析数据成功==" + comprehensive.getData().get(0).getTitle());
        adapter =new CommunityViewAdapter(mContext, comprehensive.getData());
        rvHome.setAdapter(adapter);
        GridLayoutManager manager =new GridLayoutManager(mContext,1);
        rvHome.setLayoutManager(manager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
