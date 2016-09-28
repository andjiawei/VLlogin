package com.netsite.vllogin.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.netsite.vllogin.R;
import com.netsite.vllogin.constants.Constants;
import com.netsite.vllogin.domain.ViewModel.ToolbarModel;
import com.netsite.vllogin.utils.DataBindingUtils;
import com.netsite.vllogin.utils.StatusBarCompat;

/**
 * Created by QYer on 2016/9/19.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    public ToolbarModel toolbarModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbarModel = new ToolbarModel(false,false,false,colorToDrawable(getResources().getColor(R.color.login_button_bg_end)),this);
    }

    public <T extends ViewDataBinding> T getBingContentView(int layoutId){
        return DataBindingUtil.setContentView(this, layoutId);
    }

    public void setToolBar(Constants.ToolbarState state) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        switch (state){
            case NONE:
                changeToolBarState(colorToDrawable(getResources().getColor(R.color.transparent)),false,false,"",false,"");
                break;
            case PHONE_LOGIN:
                changeToolBarState(colorToDrawable(getResources().getColor(R.color.login_button_bg_end)),true,true,getResources().getString(R.string.login_phone_login),true,getResources().getString(R.string.login_sign_up));
                break;
            case SIGN_UP:
                changeToolBarState(colorToDrawable(getResources().getColor(R.color.login_button_bg_end)),true,true,getResources().getString(R.string.login_phone_sign_up),true,getResources().getString(R.string.login_login));
                break;
            case VERIFICATION:
                changeToolBarState(colorToDrawable(getResources().getColor(R.color.login_button_bg_end)),true,true,getResources().getString(R.string.login_verification_login),false,"");
                break;
        }
    }

    private void changeToolBarState(Drawable backgroundColor,boolean isShowBackIcon,boolean isShowText,String descText,boolean isShowButton,String buttonText) {
        toolbarModel.setBackgroundColor(backgroundColor);
        toolbarModel.setShowBackIcon(isShowBackIcon);
        toolbarModel.setShowText(isShowText);
        toolbarModel.setDescText(descText);
        toolbarModel.setShowButton(isShowButton);
        toolbarModel.setButtonText(buttonText);
    }

    /**
     * 设置状态栏颜色 每个继承的activity 都可以修改
     */
    public void setStatusColor(int resColor) {
        StatusBarCompat.compat(this,resColor);
    }
   private Drawable colorToDrawable(int color){
       Drawable drawable = DataBindingUtils.convertColorToDrawable(color);
        return drawable;
   }
}
