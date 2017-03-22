package com.kangkang.biubiubiu.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by作者： 康岳龙
 * QQ：821193332 on 2017/3/21 0021.
 */

public class AppManager {
    private  AppManager(){};
    private static  AppManager appManager =new AppManager();
    public static  AppManager getInstance(){
        return  appManager;
    }
    private Stack<Activity> stack =new Stack<>();
    public void addActivity(Activity activity){
        if (activity !=null){
            stack.add(activity);
        }
    }
    public  void removeActivity(Activity activity){
        if (activity !=null){
            for (int i =stack.size()-1;i>0;i--){
                Activity currentActivity =stack.get(i);
                if (currentActivity.getClass().equals(activity.getClass())){
                    currentActivity.finish();
                    stack.remove(currentActivity);
                }
            }
        }
    }
    public void  removeAll(){
        for (int i =stack.size()-1;i>0;i--){
            Activity currentActivity =stack.get(i);
            currentActivity.finish();
            stack.remove(currentActivity);
        }
    }
    public void removeCurrentActivity(){
        Activity activity =stack.get(stack.size()-1);
        activity.finish();
        stack.remove(activity);
    }
    public int getStackSize(){
        return stack.size();
    }
    public  void  remove(Activity activicty){
        if (activicty !=null){
            for (int i =stack.size()-1;i>=0;i--){
                Activity currentActivity =stack.get(i);
                if (currentActivity == activicty){
                    stack.remove(currentActivity);
                }
            }
        }
    }
}
