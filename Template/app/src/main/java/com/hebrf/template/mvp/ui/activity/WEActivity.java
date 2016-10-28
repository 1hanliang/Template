package com.hebrf.template.mvp.ui.activity;

import com.hebrf.template.app.application.WEApplication;
import com.hebrf.template.di.commponent.AppComponent;
import com.hebrf.template.mvp.persenter.presenterbase.BasePresenter;

/**
 * Created by Administrator on 2016/10/26.
 */
public abstract class WEActivity<P extends BasePresenter> extends BaseActivity<P> {
    protected WEApplication mWeApplication;
    @Override
    protected void ComponentInject() {
        mWeApplication = (WEApplication) getApplication();
        setupActivityComponent(mWeApplication.getAppComponent());
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupActivityComponent(AppComponent appComponent);
}
