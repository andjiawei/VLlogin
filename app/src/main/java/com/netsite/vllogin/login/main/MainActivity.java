package com.netsite.vllogin.login.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.netsite.vllogin.R;
import com.netsite.vllogin.base.BaseActivity;
import com.netsite.vllogin.databinding.ActivityMainBinding;
import com.netsite.vllogin.domain.ViewModel.User;

public class MainActivity extends BaseActivity {

    User user=new User("111","222");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding bingding=DataBindingUtil.setContentView(this, R.layout.activity_main);//我草 乱报错 耽误时间
        bingding.setPresent(new MainLoginPresent(this));
        setStatusColor(getResources().getColor(R.color.transparent));
    }
}
