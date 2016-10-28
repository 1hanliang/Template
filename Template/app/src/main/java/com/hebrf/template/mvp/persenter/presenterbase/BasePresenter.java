package com.hebrf.template.mvp.persenter.presenterbase;

import com.hebrf.template.mvp.ui.viewbase.BaseView;

import org.simple.eventbus.EventBus;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by LYB on 2016/10/24.
 * 基础的中间者
 * (一只二哈和隔壁的柯基搞在一起了,真是世风日下啊(好像是形容市场不景气的))
 * (不知道爱因斯坦的相对论怎么样了)
 */
public class BasePresenter<M, V extends BaseView> implements Presenter {
    protected final String TAG = this.getClass().getSimpleName();
    protected CompositeSubscription mCompositeSubscription;

    protected M mModel;
    protected V mRootView;


    public BasePresenter(M model, V rootView) {
        this.mModel = model;
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }


    @Override
    public void onStart() {
        //注册eventbus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        //解除注册eventbus
        EventBus.getDefault().unregister(this);
        //解除订阅
        unSubscribe();
        this.mModel = null;
        this.mRootView = null;
    }

    protected void handleError(Throwable throwable) {

    }


    protected void addSubscrebe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        //将所有subscription放入,集中处理
        mCompositeSubscription.add(subscription);
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            //保证activity结束时取消所有正在执行的订阅
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void unSubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            //保证activity结束时取消所有正在执行的订阅
            subscription.unsubscribe();
        }
    }

}
