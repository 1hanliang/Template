package com.hebrf.template.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

/**
 * Created by LYB on 2016/11/4.
 */
public class NetWorkUtil {
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final int NETWOKR_TYPE_MOBILE = 2;
    public static final int NETWORK_TYPE_NONE = 3;

    /***
     * 打开网络设置
     *
     * @param c
     */
    public static void netSet(Context c) {
        c.startActivity(new Intent(Settings.ACTION_SETTINGS));
    }

    /***
     * 打开wifi设置
     *
     * @param c
     */
    public static void netSetWifi(Context c) {
        c.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    /***
     * 判断网络状态
     *
     * @param mContext
     * @return
     */
    public static int getCurrentNetType(Context mContext) {
        ConnectivityManager connManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI); // wifi
        NetworkInfo gprs = connManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE); // gprs

        if (wifi != null && wifi.getState() == NetworkInfo.State.CONNECTED) {
            return NETWORK_TYPE_WIFI;
        } else if (gprs != null && gprs.getState() == NetworkInfo.State.CONNECTED) {
            return NETWOKR_TYPE_MOBILE;
        }
        return NETWORK_TYPE_NONE;
    }

    /**
     * 判断网络是否连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

}
