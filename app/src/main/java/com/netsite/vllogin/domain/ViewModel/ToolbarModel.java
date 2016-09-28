package com.netsite.vllogin.domain.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import com.netsite.vllogin.BR;
import com.netsite.vllogin.R;
import com.netsite.vllogin.base.BaseActivity;
import com.netsite.vllogin.login.phonelogin.PhoneLoginActivity;
import com.netsite.vllogin.login.signup.SignUpActivity;

/**
 * Created by QYer on 2016/9/21.
 */
public class ToolbarModel extends BaseViewModel {

    private BaseActivity baseActivity;//暂时用binding的context
    private String descText = "";//中间显示的文本
    private String buttonText = "";//按钮上显示的文字

    private boolean isShowBackIcon;//返回是否显示
    private boolean isShowText;//中间的文本是否显示
    private boolean isShowButton;//右侧的登录注册按钮是否显示
    private Drawable drawable;//背景色 默认透明

    public ToolbarModel(boolean isShowBackIcon, boolean isShowText, boolean isShowButton, Drawable drawable, BaseActivity activity) {
        this.isShowBackIcon = isShowBackIcon;
        this.isShowText = isShowText;
        this.isShowButton = isShowButton;
        this.drawable = drawable;
        this.baseActivity = activity;
    }

    @Bindable
    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText;
        notifyPropertyChanged(BR.descText);
    }

    @Bindable
    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
        notifyPropertyChanged(BR.buttonText);
    }

    @Bindable
    public Drawable getBackgroundColor() {
        return drawable;
    }

    public void setBackgroundColor(Drawable backgroundColor) {
        this.drawable = backgroundColor;
        notifyPropertyChanged(BR.backgroundColor);
    }

    @Bindable
    public boolean isShowBackIcon() {
        return isShowBackIcon;
    }

    public void setShowBackIcon(boolean showBackIcon) {
        isShowBackIcon = showBackIcon;
        notifyPropertyChanged(BR.showBackIcon);
    }

    @Bindable
    public boolean isShowText() {
        return isShowText;
    }

    public void setShowText(boolean showText) {
        isShowText = showText;
        notifyPropertyChanged(BR.showText);
    }

    @Bindable
    public boolean isShowButton() {
        return isShowButton;
    }

    public void setShowButton(boolean showButton) {
        isShowButton = showButton;
        notifyPropertyChanged(BR.showButton);
    }

//----------get-set-分割线-----------------正在考虑下边的是否再分离出来一层--------------

    public void back(View v) {
        Log.e("vvvvvvv", "back: "+baseActivity.getLocalClassName());
        baseActivity.finish();
    }

    /**
     * toolbar右边按钮的点击
     * @param context
     */
    public void loginSignUp(Context context) {

        baseActivity= (BaseActivity) context;
        if (buttonText.equals(context.getResources().getString(R.string.login_sign_up))) {//"注册"==text
            baseActivity.startActivity(new Intent(baseActivity,SignUpActivity.class)); //跳转到注册页面
        } else if (buttonText.equals(context.getResources().getString(R.string.login_login))) {
            baseActivity.startActivity(new Intent(baseActivity,PhoneLoginActivity.class)); //跳转到登录页面
        }
    }
}
