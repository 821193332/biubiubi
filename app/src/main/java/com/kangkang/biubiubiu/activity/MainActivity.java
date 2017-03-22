package com.kangkang.biubiubiu.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kangkang.biubiubiu.R;
import com.kangkang.biubiubiu.adapter.BaseActivity;
import com.kangkang.biubiubiu.adapter.MainAdapter;
import com.kangkang.biubiubiu.base.BaseFragment;
import com.kangkang.biubiubiu.fragment.AfterSome;
import com.kangkang.biubiubiu.fragment.DirectSeeding;
import com.kangkang.biubiubiu.fragment.Find;
import com.kangkang.biubiubiu.fragment.Partition;
import com.kangkang.biubiubiu.fragment.Recommend;

import java.util.ArrayList;

import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.denglu)
    TextView denglu;
    @InjectView(R.id.youxi)
    ImageView youxi;
    @InjectView(R.id.xiazai)
    ImageView xiazai;
    @InjectView(R.id.sousuo)
    ImageView sousuo;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.nestedscrollview)
    NestedScrollView nestedscrollview;
    @InjectView(R.id.activity_main)
    CoordinatorLayout activityMain;
    @InjectView(R.id.touxiang)
    ImageView touxiang;
    @InjectView(R.id.dianjitouxiangdenglu)
    TextView dianjitouxiangdenglu;
    @InjectView(R.id.imageView)
    ImageView imageView;
    @InjectView(R.id.shouye)
    TextView shouye;
    @InjectView(R.id.wodedahuiyuan)
    TextView wodedahuiyuan;
    @InjectView(R.id.huiyuanjifen)
    TextView huiyuanjifen;
    @InjectView(R.id.lixianhuancun)
    TextView lixianhuancun;
    @InjectView(R.id.saohouzaikan)
    TextView saohouzaikan;
    @InjectView(R.id.wodeshouchang)
    TextView wodeshouchang;
    @InjectView(R.id.lishijilu)
    TextView lishijilu;
    @InjectView(R.id.wodeguanzhu)
    TextView wodeguanzhu;
    @InjectView(R.id.bbiqianbao)
    TextView bbiqianbao;
    @InjectView(R.id.zhutixuanze)
    TextView zhutixuanze;
    @InjectView(R.id.shezhiyubangzhu)
    TextView shezhiyubangzhu;
    @InjectView(R.id.cehua)
    ScrollView cehua;
    @InjectView(R.id.dl_left)
    DrawerLayout dlLeft;
    private ArrayList<BaseFragment> fragments;
    private MainAdapter adapter;

    @Override
    protected void initListener() {
      denglu.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              dlLeft.openDrawer(Gravity.LEFT);

          }
      });

    }

    @Override
    protected void initData() {
        Log.e("TAG", "发现的数据被初始化了...");
        initFragment();
        adapter = new MainAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new DirectSeeding());//直播
        fragments.add(new Recommend());//推荐
        fragments.add(new AfterSome());//追番
        fragments.add(new Partition());//分区
        fragments.add(new Find());//发现
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_main;
    }




}
