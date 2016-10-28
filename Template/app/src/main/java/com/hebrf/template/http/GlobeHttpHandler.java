package com.hebrf.template.http;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by LYB on 2016/10/22.
 * 没啥想说的,就是很开森
 */
public interface GlobeHttpHandler {
    //响应
    Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response);
    //请求
    Request onHttpRequestBefore(Interceptor.Chain chain, Request request);
}
