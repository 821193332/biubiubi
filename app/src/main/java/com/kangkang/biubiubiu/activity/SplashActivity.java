package com.kangkang.biubiubiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.kangkang.biubiubiu.R;

public class SplashActivity extends AppCompatActivity {

    //设置时间
    private Handler handler =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //设置2秒进入主页面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //执行在主线程
                /*启动主页面，并在开场界面创建（WelComeActivity）创建starMainActivity类
                关联主页面*/
                starMainActivity();
            }
            //添加，时间括号外；号结束
        },2000);
    }
    //主页面  先创建主页面并在主线程 启动
    private  void starMainActivity(){
        //关联主页面
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        //关闭当前页面
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //点击快速进入主页面
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            starMainActivity();
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除消息
        handler.removeCallbacksAndMessages(null);
    }
}