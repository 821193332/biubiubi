package com.kangkang.biubiubiu.fragment.tj.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.fragment.tj.bean.Comprehensive;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/24 0024.
 * 适配器
 */

public class CommunityShiPei extends BaseAdapter {
    private final Context mContext;
    private final List<Comprehensive.DataBean> datas;


    public CommunityShiPei(Context context, List<Comprehensive.DataBean> dataw) {
        this.mContext = context;
        this.datas = dataw;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.community, null);
            viewHolder =new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Comprehensive.DataBean dataBean = datas.get(position);

        Glide.with(mContext).load(dataBean.getCover()).
                diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(viewHolder.xianshi);
           viewHolder.biaoti.setText(datas.get(position).getTitle());
        viewHolder.pindao.setText(datas.get(position).getTname());
        //viewHolder.biaoqian.setText(datas.get(position).getDislike_reasons());

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.xianshi)
        ImageView xianshi;
        @InjectView(R.id.biaoti)
        TextView biaoti;
        @InjectView(R.id.pindao)
        TextView pindao;
        @InjectView(R.id.biaoqian)
        TextView biaoqian;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
