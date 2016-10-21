package com.netsite.vllogin.utils.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.netsite.vllogin.R;

/**
 * Created by QYer on 2016/9/20.
 */
public class EditTextWithClearButton extends EditText implements View.OnFocusChangeListener, TextWatcher {

    private static final int MAX_LENGTH = 13;//最大长度
    private Drawable mClearDrawable;    // 删除按钮的引用
    private boolean hasFocus;           // 控件是否有焦点
    private int currentIndex = -1;      //当前第几个数字 用于判断回退可清除空格
    private Boolean isShow = false;

    public EditTextWithClearButton(Context context) {
        super(context);
        init();
    }

    public EditTextWithClearButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextWithClearButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // 获取EditText的DrawableRight，假如没有设置我们使用默认的图片
        mClearDrawable = getCompoundDrawables()[2];
        if (mClearDrawable == null) {
            mClearDrawable = getResources().getDrawable(R.drawable.button_bc_close);//设置X号的图片
        }
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth() * 2 / 3, mClearDrawable.getIntrinsicHeight() * 2 / 3);// 除以 用来缩小图片
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(MAX_LENGTH)});//maxLength
        // 默认设置隐藏图标
        setClearIconVisible(false);
        // 设置焦点改变的监听器
        setOnFocusChangeListener(this);
        // 设置输入框里面内容发生改变的监听
        addTextChangedListener(this);
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
                        - getPaddingRight() - mClearDrawable.getIntrinsicWidth())
                        && (event.getX() < ((getWidth() - getPaddingRight())));
                if (touchable) {
                    this.setText("");//这个就是点击事件产生的效果
                }
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 当ClearEditText焦点发生变化的时候，判断里面字符串长度设置清除图标的显示与隐藏
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {//修改文字时回调
        this.hasFocus = hasFocus;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);//长度大于0时，不现实X号
        } else {
            setClearIconVisible(false);
        }
    }

    private void addSpace() {
        String text = getText().toString().trim();
        if (text.length() == 4 && isAdd()) {
            text = insertSpace(text);
        }
        if (text.length() == 9 && isAdd()) {
            text = insertSpace(text);
        }
        if (text.length() == 13 && isAdd()) {
            showDialog(isShow);
            hideSoft();
            if(listener!=null){
                listener.onPhoneInputComplete();
            }
        }
        currentIndex = getText().length();
    }

    private void hideSoft() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void showDialog(Boolean isShow) {
        if (isShow) {
            //todo 弹出苹果风格的对话框
        }
    }

    private String insertSpace(String text) {
        String s = text.substring(0, text.length() - 1) + " " + text.charAt(text.length() - 1);
        setText(s);
        setSelection(s.length());
        return s;
    }

    private boolean isAdd() {
        int newIndex = getText().length();
        return currentIndex < newIndex;
    }


    /**
     * 设置清除图标的显示与隐藏，调用setCompoundDrawables为EditText绘制上去
     *
     * @param visible
     */
    protected void setClearIconVisible(boolean visible) {//true 时显示 drawable false right==null 不显示
        Drawable right = visible ? mClearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0],
                getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }

    public void setShowDialog(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 当输入框里面内容发生变化的时候回调的方法
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int count, int after) {
        if (hasFocus) {
            addSpace();//第3位 第7位后加空格 最后一位弹对话框
            setClearIconVisible(s.length() > 0);//长度大于0时，不现实X号
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private OnPhoneInputCompleteListener listener;

    public void setOnPhoneInputCompleteListener(OnPhoneInputCompleteListener listener){
        this.listener=listener;
    }

    public interface OnPhoneInputCompleteListener{
        void onPhoneInputComplete();
    }

}
