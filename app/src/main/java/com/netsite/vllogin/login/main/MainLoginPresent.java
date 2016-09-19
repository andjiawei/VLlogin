package com.netsite.vllogin.login.main;

import android.util.Log;
import android.view.View;

/**
 * Created by QYer on 2016/9/19.
 */
public class MainLoginPresent {

    private final MainActivity mainActivity;
    public MainLoginPresent(MainActivity activity){
        mainActivity =activity;
    }
    public void phoneLogin(View view) {
        Log.e("MainLoginPresent", "phoneLogin: ");
    }
    public void signUp(View view) {
        Log.e("MainLoginPresent", "signUp: ");
    }
    public void qqLogin(View view) {
        Log.e("MainLoginPresent", "qqLogin: ");
    }
    public void weChatLogin(View view) {
        Log.e("MainLoginPresent", "weChatLogin: ");
    }
    public void weiboLogin(View view) {
        Log.e("MainLoginPresent", "weiboLogin: ");
    }
    public void  article(View view) {
        Log.e("MainLoginPresent", "article: ");
    }
}
