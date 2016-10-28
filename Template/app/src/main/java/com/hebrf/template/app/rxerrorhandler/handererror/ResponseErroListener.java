package com.hebrf.template.app.rxerrorhandler.handererror;

import android.content.Context;

/**
 * Created by LYB on 2016/10/24.
 */
public interface ResponseErroListener {
    void handleResponseError(Context context, Exception e);
}
