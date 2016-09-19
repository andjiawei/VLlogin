package com.netsite.vllogin.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.netsite.vllogin.utils.StatusBarCompat;

/**
 * Created by QYer on 2016/9/19.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    /**
     * 设置状态栏颜色 每个继承的activity 都可以修改
     * @param resColor
     */
    protected void setStatusColor(int resColor) {
        StatusBarCompat.compat(this,resColor);
    }
}
