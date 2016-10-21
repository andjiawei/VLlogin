package com.netsite.vllogin.utils.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.netsite.vllogin.R;

public class VerificationEditText extends LinearLayout implements  View.OnClickListener {

    private static final long COUNT_SECOND = 3000;//总共多少秒
    private Context context;
    private String verifyCode;
    private EditText et;
    private CountDownTimer timer;
    private TextView tv_send_verify_code;


    public VerificationEditText(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public VerificationEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public VerificationEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context=context;
        init();
    }

    private void init() {
        LayoutInflater.from(context).inflate(R.layout.widget_verifi_editext,this);
        findViewById(R.id.ll_send_verify).setOnClickListener(this);
        et = ((EditText)findViewById(R.id.et_input_verify));
        tv_send_verify_code = (TextView)findViewById(R.id.tv_send_verify_code);
        initCountDown();
    }

    private void initCountDown() {
        timer = new CountDownTimer(COUNT_SECOND,1000) {
            public void onTick(long millisUntilFinished) {
                tv_send_verify_code.setText( millisUntilFinished / 1000+"s后重发");
            }
            public void onFinish() {
                tv_send_verify_code.setText("发送验证码");
            }
        };
    }

    @Override
    public void onClick(View v) {
        if(!isInvalid()){
            //1 执行发送操作

            //2 开始倒计时
            timer.start();
        }
    }

    private boolean isInvalid() {
        verifyCode = et.getText().toString();
        if(TextUtils.isEmpty(verifyCode)){
            Toast.makeText(context,"请输入正确的验证码",Toast.LENGTH_SHORT).show();
            return true;
        }

        if(verifyCode.length()!=4){
            Toast.makeText(context,"验证码为4位",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
