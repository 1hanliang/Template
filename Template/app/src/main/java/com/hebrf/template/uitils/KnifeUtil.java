package com.hebrf.template.uitils;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by LYB on 2016/10/24.
 */
public class KnifeUtil {
    public static void bindTarget(Object target, Object source) {
        if (source instanceof Activity) {
            ButterKnife.bind(target, (Activity) source);
        } else if (source instanceof View) {
            ButterKnife.bind(target, (View) source);
        } else if (source instanceof Dialog) {
            ButterKnife.bind(target, (Dialog) source);
        }
    }
}

