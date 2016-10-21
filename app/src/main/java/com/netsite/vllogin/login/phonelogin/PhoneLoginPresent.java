package com.netsite.vllogin.login.phonelogin;

import android.view.View;

import com.netsite.vllogin.base.BaseActivity;
import com.netsite.vllogin.login.verifilogin.VerifiLoginActivity;

/**
 * Created by QYer on 2016/9/21.
 */
public class PhoneLoginPresent {

    private BaseActivity activity;

    public PhoneLoginPresent(BaseActivity activity){
        this.activity=activity;
    }

    public void verifiLogin(View v){
        activity.startActivity(VerifiLoginActivity.class);
    }

    public void login(View view){

    }
}
