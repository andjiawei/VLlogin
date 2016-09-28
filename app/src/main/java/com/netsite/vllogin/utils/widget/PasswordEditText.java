package com.netsite.vllogin.utils.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.netsite.vllogin.R;

/**
 * Created by QYer on 2016/9/20.
 */
public class PasswordEditText extends EditText implements View.OnFocusChangeListener {

    private static final int MAX_LENGTH = 20;//最大长度
    private Drawable mEyeOpenDrawable;
    private Drawable mEyeCloseDrawable;
    private boolean hasFocus;           // 控件是否有焦点
    private int currentIndex = -1;      //当前第几个数字 用于判断回退可清除空格
    private Boolean isOpen = false;

    public PasswordEditText(Context context) {
        super(context);
        init();
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PasswordEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // 获取EditText的DrawableRight，假如没有设置我们使用默认的图片
        mEyeCloseDrawable = getCompoundDrawables()[2];
        if (mEyeCloseDrawable == null) {
            mEyeCloseDrawable = getResources().getDrawable(R.drawable.login_eyes_closed);//设置眼睛照片
        }
        if(mEyeOpenDrawable==null){
            mEyeOpenDrawable = getResources().getDrawable(R.drawable.login_eyes_open);
        }
        mEyeCloseDrawable.setBounds(0, 0, mEyeCloseDrawable.getIntrinsicWidth() , mEyeCloseDrawable.getIntrinsicHeight() );// 除以 用来缩小图片
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(MAX_LENGTH)});//maxLength
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], mEyeCloseDrawable, getCompoundDrawables()[3]);
    }


    /**
     * 因为我们不能直接给EditText设置点击事件，所以我们用记住我们按下的位置来模拟点击事件
     * 当我们按下的位置在EditText的宽度 - 图标到控件右边的间距 - 图标的宽度 和
     * EditText的宽度 - 图标到控件右边的间距之间我们就算点击了图标，竖直方向没有考虑
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getCompoundDrawables()[2] != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                boolean touchable = event.getX() > (getWidth()
                        - getPaddingRight() - mEyeCloseDrawable.getIntrinsicWidth())
                        && (event.getX() < ((getWidth() - getPaddingRight())));
                if (touchable) {
                    changeShowPassword(isOpen);
                }
            }
        }
        return super.onTouchEvent(event);
    }


    private void changeShowPassword(boolean isOpen){
        if(isOpen){
            setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD );
        }else{
            setInputType(EditorInfo.TYPE_CLASS_TEXT);
        }
        this.isOpen=!isOpen;
        Drawable right = this.isOpen ? mEyeOpenDrawable :  mEyeCloseDrawable;
        right.setBounds(0, 0, right.getIntrinsicWidth() , right.getIntrinsicHeight() );//两行必须同时设置 和下边那行
        setCompoundDrawables(getCompoundDrawables()[0],getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
        setSelection(getText().length());
    }

    /**
     * 当输入框里面内容发生变化的时候回调的方法
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int count, int after) {
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }
}
