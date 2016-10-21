package com.netsite.vllogin.login.verifilogin;

import android.os.Bundle;

import com.netsite.vllogin.R;
import com.netsite.vllogin.base.BaseActivity;
import com.netsite.vllogin.constants.Constants;
import com.netsite.vllogin.databinding.ActivityVerifiLoginBinding;

public class VerifiLoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVerifiLoginBinding binding = getBingContentView(R.layout.activity_verifi_login);
        binding.setPresent(new VerifiLoginPresent(this));
        binding.setToolbar(toolbarModel);
        setStatusColor(getResources().getColor(R.color.login_button_bg_end));//设置状态栏颜色
        setToolBar(Constants.ToolbarState.VERIFICATION);
    }
}
