package com.hebrf.template.mvp.persenter.presenterbase;

import com.hebrf.template.app.rxerrorhandler.core.RxErrorHandler;
import com.hebrf.template.app.rxerrorhandler.handererror.ErrorHandleSubscriber;
import com.hebrf.template.app.rxerrorhandler.handererror.RetryWithDelay;
import com.hebrf.template.contract.UserContract;
import com.hebrf.template.di.scope.ActivityScope;
import com.hebrf.template.mvp.model.entity.User;
import com.hebrf.template.mvp.ui.activity.BaseActivity;
import com.hebrf.template.mvp.ui.adapter.DefaultAdapter;
import com.hebrf.template.mvp.ui.adapter.UserAdapter;
import com.hebrf.template.utils.PermissionUtil;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/26.
 */
@ActivityScope
public class UserPresenter extends BasePresenter<UserContract.Model, UserContract.View> {
    private RxErrorHandler mErrorHandler;
    private RxPermissions mRxPermissions;
    private List<User> mUsers = new ArrayList<>();
    private DefaultAdapter mAdapter;
    private int lastUserId = 1;


    @Inject
    public UserPresenter(UserContract.Model model, UserContract.View rootView, RxErrorHandler handler
            , RxPermissions rxPermissions) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mRxPermissions = rxPermissions;
        mAdapter = new UserAdapter(mUsers);
        mRootView.setAdapter(mAdapter);//设置Adapter
    }

    public void requestUsers(final boolean pullToRefresh) {

        //请求外部存储权限用于适配android6.0的权限管理机制
        PermissionUtil.externalStorage(new PermissionUtil.RequestPermission() {
            @Override
            public void onRequestPermissionSuccess() {
                //request permission success, do something.
            }
        }, mRxPermissions, mRootView, mErrorHandler);


        if (pullToRefresh) lastUserId = 1;

        mModel.getUsers(lastUserId, pullToRefresh)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (pullToRefresh)
                            mRootView.showLoading();//显示上拉刷新的进度条
                        else
                            mRootView.startLoadMore();
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(new Action0() {
                    @Override
                    public void call() {
                        if (pullToRefresh)
                            mRootView.hideLoading();//隐藏上拉刷新的进度条
                        else
                            mRootView.endLoadMore();
                    }
                })
                .compose(((BaseActivity) mRootView).<List<User>>bindToLifecycle())//使用RXlifecycle,使subscription和activity一起销毁
                .subscribe(new ErrorHandleSubscriber<List<User>>(mErrorHandler) {
                    @Override
                    public void onNext(List<User> users) {
                        lastUserId = users.get(users.size() - 1).getId();//记录最后一个id,用于下一次请求
                        if (pullToRefresh) mUsers.clear();//如果是上拉刷新则晴空列表
                        for (User user : users) {
                            mUsers.add(user);
                        }
                        mAdapter.notifyDataSetChanged();//通知更新数据
                    }
                });
    }
}
