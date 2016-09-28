package com.netsite.vllogin.utils;

import android.databinding.BindingConversion;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by QYer on 2016/9/21.
 */
public class DataBindingUtils {

    @BindingConversion
    public static Drawable convertColorToDrawable(int drawable) {
        return new ColorDrawable(drawable);
    }

}
