package com.kangkang.biubiubiu.fragment.zb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.fragment.zb.bean.Constants;
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
    public static final int BANNER = 0; //图片
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
    private LayoutInflater inflater;
    private Context mContext;
    private Constants.DataBean dataBean;

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
        //return dataBean.getBanner() != null ?dataBean.getBanner().size():0;
        return 2;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("TAG", "aaaaaaaaaaaaaaaa" + viewType + BANNER);
        if (viewType == BANNER) {
            Log.e("TAG", "String=====77777");
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        } else if (viewType == CHANNEL) {
            return new ChannelViewHolder( inflater.inflate(R.layout.channel_item, null));
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
            viewHolder.setData(mContext,5);
        }
    }


    static class ChannelViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.gridview)
        GridView gridview;
        //设置适配器
        private ChanneBaseAdapter baseAdapter;
        private List<String> mList;


        public ChannelViewHolder( View view) {
            super(view);
            ButterKnife.inject(this,view);

        }

        public void setData( Context context, int i) {
          mList =new ArrayList<>();
            mList.add("关注");
            mList.add("中心");
            mList.add("小视频");
            mList.add("搜索");
            mList.add("分类");
            baseAdapter =new ChanneBaseAdapter(context,mList);
            gridview.setAdapter(baseAdapter);

        }
    }
}

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
