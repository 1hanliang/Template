package com.hebrf.template.mvp.model.api.cache;

import javax.inject.Inject;

/**
 * Created by LYB on 2016/10/24.
 */
public class CacheManager extends BaseCacheManager{

    private CommonCache mCommonCache;

    /**
     * 如果需要添加Cache只需在构造方法中添加对应的Cache,
     * 在提供get方法返回出去,只要在CacheModule提供了该Cache Dagger2会自行注入
     * @param commonCache
     */
    @Inject
    public CacheManager(CommonCache commonCache) {
        this.mCommonCache = commonCache;
    }

    public CommonCache getCommonCache() {
        return mCommonCache;
    }

}
