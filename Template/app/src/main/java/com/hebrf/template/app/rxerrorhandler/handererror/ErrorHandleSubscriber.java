package com.hebrf.template.app.rxerrorhandler.handererror;

import com.hebrf.template.app.rxerrorhandler.core.RxErrorHandler;

import rx.Subscriber;

/**
 * Created by LYB on 2016/10/24.
 */
public abstract class ErrorHandleSubscriber<T> extends Subscriber<T> {
    private ErrorHandlerFactory mHandlerFactory;

    public ErrorHandleSubscriber(RxErrorHandler rxErrorHandler){
        this.mHandlerFactory = rxErrorHandler.getmHandlerFactory();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        mHandlerFactory.handleError(e);
    }

}

