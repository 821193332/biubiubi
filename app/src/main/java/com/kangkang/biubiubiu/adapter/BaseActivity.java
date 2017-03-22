package com.kangkang.biubiubiu.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/21 0021.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutid());
        ButterKnife.inject(this);
        initTitle();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initTitle() ;
    public abstract int getLayoutid();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
    public void showToast(String context){
        Toast.makeText(this, context, Toast.LENGTH_SHORT).show();
    }
}
