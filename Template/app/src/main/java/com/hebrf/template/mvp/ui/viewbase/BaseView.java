package com.hebrf.template.mvp.ui.viewbase;

import android.content.Intent;

/**
 * Created by Administrator on 2016/10/24.
 */
public interface BaseView {


    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示信息
     */
    void showMessage(String message);

    /**
     * 跳转activity
     */
    void launchActivity(Intent intent);
    /**
     * 杀死自己
     */
    void killMyself();
}
