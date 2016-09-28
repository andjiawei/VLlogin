package com.netsite.vllogin.login.phonelogin;

import android.os.Bundle;

import com.netsite.vllogin.R;
import com.netsite.vllogin.base.BaseActivity;
import com.netsite.vllogin.constants.Constants;
import com.netsite.vllogin.databinding.ActivityPhoneLoginBinding;

public class PhoneLoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhoneLoginBinding binding = getBingContentView(R.layout.activity_phone_login);
//      bingding.setPresent(new MainLoginPresent(this));
        binding.setToolbar(toolbarModel);
        setStatusColor(getResources().getColor(R.color.login_button_bg_end));//设置状态栏颜色
        setToolBar(Constants.ToolbarState.PHONE_LOGIN);
    }
}
