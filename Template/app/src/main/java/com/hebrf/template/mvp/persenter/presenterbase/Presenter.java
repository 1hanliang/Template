package com.hebrf.template.mvp.persenter.presenterbase;

import rx.Subscription;

/**
 * Created by LYB on 2016/10/24.
 * (隔壁的二哈疯了)
 */
public interface Presenter {
    void onStart();
    void onDestroy();
    void unSubscribe(Subscription subscription);
}
