package com.hebrf.template.utils;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by LYB on 2016/10/28.
 *Toast的工具类
 */
public class ToastUitils {
    private static Toast toast = null;

    /**
     * 展示文字类型的吐司
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        showToast(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
    }

    /**
     * 展示数字类型的吐司
     * @param context
     * @param msg
     */
    public static void showToast(Context context, int msg) {
        showToast(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
    }

    /**
     * 出现异常的情况弹出的吐司
     * @param context
     * @param root
     * @param tvString
     */
    public static synchronized void  showErrorToast(Context context, ViewGroup root, String tvString){
        if (toast != null) {
            toast.setText(tvString);
            toast.show();
        } else {
            toast = Toast.makeText(context, tvString, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private static synchronized void showToast(final Context act, final String msg, final int len) {

        if (toast != null) {
            toast.setText(msg);
            toast.show();
        } else {
            toast = Toast.makeText(act, msg, len);
            toast.show();
        }
    }

    private static synchronized void showToast(final Context act, final int msg, final int len) {

        if (toast != null) {
            toast.setText(msg);
            toast.show();
        } else {
            toast = Toast.makeText(act, msg, len);
            toast.show();
        }
    }
}


