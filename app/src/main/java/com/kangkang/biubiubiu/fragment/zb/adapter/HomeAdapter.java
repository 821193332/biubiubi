package com.kangkang.biubiubiu.fragment.zb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.fragment.zb.bean.Constants;
import com.kangkang.biubiubiu.fragment.zb.bean.HuiHuaShuJu;
import com.kangkang.biubiubiu.fragment.zb.view.MyGridView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/22 0022.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * 六种类型
     */
    /**
     * 横幅广告-要从0开
     */
    public static final int BANNER = 0; //banner标头广告
    /**
     * 频道
     */
    public static final int CHANNEL = 1;//分类

    /**
     * 活动
     */
    public static final int ZHIBO = 2;//直播

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
    private LayoutInflater inflater;
    private Context mContext;
    private Constants.DataBean dataBean;
    private List<HuiHuaShuJu.LivesBean> huiHuaShuJu;

    public HomeAdapter(Context mContext, Constants.DataBean data) {
        this.mContext = mContext;
        this.dataBean = data;
        inflater = LayoutInflater.from(mContext);
        Log.e("TAG", "String=====00000");
    }

    /*public void refresh(Constants.DataBean dataBean){
        this.dataBean=dataBean;
        notifyDataSetChanged();
    }*/
    /**
     * 当前类型
     */
    public int currentType = BANNER;

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        } else if (position == CHANNEL) {
            currentType = CHANNEL;
        } else if (position == ZHIBO) {
            currentType = ZHIBO;
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
        //return dataBean.getBanner() != null ?dataBean.getBanner().size():0;
        return 3;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("TAG", "aaaaaaaaaaaaaaaa" + viewType + BANNER);
        if (viewType == BANNER) {
            Log.e("TAG", "String=====77777");
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        } else if (viewType == CHANNEL) {
            return new ChannelViewHolder(inflater.inflate(R.layout.channel_item, null));
        } else if (viewType == ZHIBO) {
            return new ZhiBoViewHolder(mContext, inflater.inflate(R.layout.zhi_bo, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder viewHolder = (BannerViewHolder) holder;
            viewHolder.setData(dataBean.getBanner());

        } else if (getItemViewType(position) == CHANNEL) {
            ChannelViewHolder viewHolder = (ChannelViewHolder) holder;
            viewHolder.setData(mContext, 5);
        } else if (getItemViewType(position) == ZHIBO) {
            ZhiBoViewHolder viewHolder = (ZhiBoViewHolder) holder;
            viewHolder.setData(mContext,dataBean.getPartitions());
        }
    }

    //分类
    static class ChannelViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.gridview)
        GridView gridview;
        //设置适配器
        private ChanneBaseAdapter baseAdapter;
        private List<String> mList;


        public ChannelViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);

        }

        public void setData(Context context, int i) {
            mList = new ArrayList<>();
            mList.add("关注");
            mList.add("中心");
            mList.add("小视频");
            mList.add("搜索");
            mList.add("分类");
            baseAdapter = new ChanneBaseAdapter(context, mList);
            gridview.setAdapter(baseAdapter);

        }
    }

    //直播
     class ZhiBoViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.tuijianzhubo)
        TextView tuijianzhubo;
        @InjectView(R.id.zhiboshuzi)
        TextView zhiboshuzi;
        @InjectView(R.id.zhibojiantou)
        TextView zhibojiantou;
        @InjectView(R.id.tuijianzhibobiaotou)
        LinearLayout tuijianzhibobiaotou;
        @InjectView(R.id.gridview)
        MyGridView gridview;

        //直播适配器
        private ZhiBoBaseAdapter zhibo;

        public ZhiBoViewHolder(Context mContext, View view) {
            super(view);
            ButterKnife.inject(this,view);
        }

        public void setData(final Context context, List<Constants.DataBean.PartitionsBean> huiHuaShuJu) {
            zhibo = new ZhiBoBaseAdapter(context, huiHuaShuJu);
             gridview.setAdapter(zhibo);
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context,"position=="+position,Toast.LENGTH_SHORT).show();
                    Log.e("TAG","测试成功");
                }
            });

        }
    }
}

//广告条幅

class BannerViewHolder extends RecyclerView.ViewHolder {


    private final Context mContext;
    private Banner banner;

    public BannerViewHolder(Context mContext, View itemView) {
        super(itemView);
        this.mContext = mContext;
        banner = (Banner) itemView.findViewById(R.id.banner);

    }

    public void setData(List<Constants.DataBean.BannerBean> data) {
        List<String> images = new ArrayList<>();
        Log.e("TAG", "String=====");
        for (int i = 0; i < data.size(); i++) {
            images.add(data.get(i).getImg());
            images.add(data.get(i).getImg());
        }

        banner.setImages(images).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).crossFade().into(imageView);
            }
        }).start();
        banner.setBannerAnimation(BackgroundToForegroundTransformer.class);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
