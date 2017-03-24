package com.kangkang.biubiubiu.fragment.tj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.fragment.tj.bean.Comprehensive;
import com.kangkang.biubiubiu.fragment.zb.view.MyGridView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/24 0024.
 */

public class CommunityViewAdapter extends RecyclerView.Adapter {
    /**
     * 六种类型
     */
    /**
     * 横幅广告-要从0开
     */
    public static final int TUIJIAN = 0;
    /**
     * 频道
     */
    public static final int CHANNEL = 1;

    /**
     * 活动
     */
    public static final int ACT = 2;

    /**
     * 秒杀
     */
    public static final int SECKILL = 3;
    /**
     * 推荐
     */
    public static final int RECOMMEND = 4;
    /**
     * 热卖
     */
    public static final int HOT = 5;
    /**
     * 用他加载布局
     */
    private final LayoutInflater inflater;
    private final Context mContext;
    private final List<Comprehensive.DataBean> dataw;

    /**
     * 当前类型
     */
    public int currentType = TUIJIAN;


    @Override
    public int getItemViewType(int position) {
        if (position == TUIJIAN) {
            currentType = TUIJIAN;
            Log.e("TAG", "getItemViewType: 11111" );
        } else if (position == CHANNEL) {
            currentType = CHANNEL;
        } else if (position == ACT) {
            currentType = ACT;
        } else if (position == SECKILL) {
            currentType = SECKILL;
        } else if (position == RECOMMEND) {
            currentType = RECOMMEND;
        } else if (position == HOT) {
            currentType = HOT;
        }
        return currentType;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public CommunityViewAdapter(Context mContext, List<Comprehensive.DataBean> dataw) {
        this.mContext = mContext;
        this.dataw = dataw;
        inflater = LayoutInflater.from(mContext);
        Log.e("TAG", "getItemViewType: 2222" );
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TUIJIAN) {
            return new ActViewHolder(mContext, inflater.inflate(R.layout.actview, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TUIJIAN) {
            ActViewHolder viewHolder = (ActViewHolder) holder;
            viewHolder.setData(mContext, dataw);
            Log.e("TAG", "getItemViewType: 4444" );

        }
    }


 class ActViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.gridview)
        MyGridView gridview;
       CommunityShiPei adapter;

        public ActViewHolder(Context mContext, View view) {
            super(view);
            ButterKnife.inject(this,view);
            Log.e("TAG", "getItemViewType: 2255552" );
        }

        public void setData(final Context mContext, List<Comprehensive.DataBean> dataw) {
            adapter =new CommunityShiPei(mContext,dataw);
           gridview.setAdapter(adapter);
            Log.e("TAG", "getItemViewType: 7777" );
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext,"position=="+position,Toast.LENGTH_SHORT).show();
                    Log.e("TAG","测试成功");
                }
            });
        }
    }
}
