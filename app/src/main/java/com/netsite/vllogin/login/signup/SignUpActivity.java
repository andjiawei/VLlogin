package com.netsite.vllogin.login.signup;

import android.os.Bundle;

import com.netsite.vllogin.R;
import com.netsite.vllogin.base.BaseActivity;
import com.netsite.vllogin.constants.Constants;
import com.netsite.vllogin.databinding.ActivitySignUpBinding;

public class SignUpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignUpBinding bingding=getBingContentView(R.layout.activity_sign_up);
        bingding.setToolbar(toolbarModel);
        setToolBar(Constants.ToolbarState.SIGN_UP);
        setStatusColor(getResources().getColor(R.color.login_button_bg_end));
    }
}
