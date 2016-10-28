package com.hebrf.template.mvp.model.modelbase;

import com.hebrf.template.mvp.model.api.cache.BaseCacheManager;
import com.hebrf.template.mvp.model.api.service.BaseServiceManager;

/**
 * Created by LYB on 2016/10/22.
 */
public class BaseModel<S extends BaseServiceManager, C extends BaseCacheManager> {
    protected S mServiceManager;//服务管理类,用于网络请求
    protected C mCacheManager;//缓存管理类,用于管理本地或者内存缓存

    public BaseModel(S serviceManager, C cacheManager) {
        this.mServiceManager = serviceManager;
        this.mCacheManager = cacheManager;
    }

    public void onDestory() {
        mServiceManager = null;
        mCacheManager = null;
    }
}
