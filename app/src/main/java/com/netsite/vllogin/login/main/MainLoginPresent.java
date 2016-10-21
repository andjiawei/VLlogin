package com.netsite.vllogin.login.main;

import android.util.Log;
import android.view.View;

import com.netsite.vllogin.base.BaseActivity;
import com.netsite.vllogin.login.phonelogin.PhoneLoginActivity;
import com.netsite.vllogin.login.signup.SignUpActivity;

/**
 * Created by QYer on 2016/9/19.
 */
public class MainLoginPresent {

    private  BaseActivity activity;
    public MainLoginPresent(BaseActivity activity){
        this.activity =activity;
    }

    /**
     * 手机号登录按钮的点击事件
     */
    public void phoneLogin(View view) {
        activity.startActivity(PhoneLoginActivity.class);
    }
    public void signUp(View view) {
        activity.startActivity(SignUpActivity.class);
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
