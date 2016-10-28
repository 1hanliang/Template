package com.hebrf.template.mvp.model.api.cache;

import com.hebrf.template.mvp.model.entity.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictProvider;
import io.rx_cache.LifeCache;
import io.rx_cache.Reply;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/24.
 */
public interface CommonCache {

    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<List<User>>>
    getUsers(Observable<List<User>> oUsers,
             DynamicKey idLastUserQueried, EvictProvider evictProvider);

    //DynamicKey 动态的 EvictProvider逐出提供者

//    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
//    Observable<Reply<HomePicEntity>> getDailyList(Observable<HomePicEntity> service, DynamicKey publishTime, EvictProvider provider);
//
//    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
//    Observable<Reply<FindMoreEntity>> getFindMore(Observable<FindMoreEntity> service, DynamicKey id, EvictProvider provider);
//
//
//    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
//    Observable<Reply<HotStrategyEntity>> getHotStrategy(Observable<HotStrategyEntity> service, DynamicKey id, EvictProvider provider);
//
//
//    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
//    Observable<Reply<FindDetailEntity>> getFindDetail(Observable<FindDetailEntity> service, DynamicKey id, EvictProvider provider);



}
