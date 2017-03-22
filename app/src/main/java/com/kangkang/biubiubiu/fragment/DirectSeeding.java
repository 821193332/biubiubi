package com.kangkang.biubiubiu.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.base.BaseFragment;
import com.kangkang.biubiubiu.fragment.zb.adapter.HomeAdapter;
import com.kangkang.biubiubiu.fragment.zb.bean.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/21 0021.
 */

public class DirectSeeding extends BaseFragment {

    @InjectView(R.id.rv_home)
    RecyclerView rvHome;
    /*@InjectView(R.id.ib_top)
    ImageButton ibTop;*/
    private HomeAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    protected void initData() {

        super.initData();
        Log.e("TAG", "直播页面数据被初始化了...");
        getDataFromNet();

    }

    public void getDataFromNet() {

        OkHttpUtils.get().url("http://live.bilibili.com/AppNewIndex/common?_device=android&appkey=\n" +
                "1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&scale=\n" +
                "hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b").id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("TAG", "联网失败==" + e.getMessage());
            }

            @Override
            public void onResponse(final String response, int id) {
                //主线程 分线程
                Log.e("TAG", "联网成功==");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ProcessedData(response);
                    }
                });

            }
        });
    }

    private void ProcessedData(String response) {

        Constants constants = JSON.parseObject(response, Constants.class);
        Log.e("TAG", "解析数据成功==" + constants.getData().getBanner().size());
        //adapter.refresh(constants.getData());
        Log.e("TAG", "解析数据成功==" + constants.getData().getBanner());
        adapter = new HomeAdapter(mContext,constants.getData());
        GridLayoutManager manager = new GridLayoutManager(mContext, 1);
        rvHome.setAdapter(adapter);
        rvHome.setLayoutManager(manager);
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position <= 3) {
//                    ibTop.setVisibility(View.GONE);
//                } else {
//                    ibTop.setVisibility(View.VISIBLE);
//                }
//                return 1;
//            }
//        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
