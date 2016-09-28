package com.netsite.vllogin.login.main;

import android.content.Intent;
import android.os.Bundle;

import com.netsite.vllogin.R;
import com.netsite.vllogin.base.BaseActivity;
import com.netsite.vllogin.constants.Constants;
import com.netsite.vllogin.databinding.ActivityMainBinding;
import com.netsite.vllogin.domain.ViewModel.User;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bingding=getBingContentView(R.layout.activity_main);
        bingding.setUser(new User("111","222"));
        bingding.setPresent(new MainLoginPresent(this));
        bingding.setToolbar(toolbarModel);
        setStatusColor(getResources().getColor(R.color.transparent));//设置状态栏颜色
        setToolBar(Constants.ToolbarState.NONE);//隐藏toolbar
    }

    public void startActivity(Class< ? extends BaseActivity> clazz){
        startActivity(new Intent(this,clazz));
    }
}
