package com.hebrf.template.mvp.model;

import com.hebrf.template.contract.UserContract;
import com.hebrf.template.mvp.model.api.cache.CacheManager;
import com.hebrf.template.mvp.model.api.cache.CommonCache;
import com.hebrf.template.mvp.model.api.service.CommonService;
import com.hebrf.template.mvp.model.api.service.ServiceManager;
import com.hebrf.template.mvp.model.entity.User;
import com.hebrf.template.mvp.model.modelbase.BaseModel;

import java.util.List;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Administrator on 2016/10/26.
 */
public class UserModel extends BaseModel<ServiceManager,CacheManager> implements UserContract.Model{
    public static final int USERS_PER_PAGE = 10;
    private CommonService mCommonService;
    private CommonCache mCommonCache;

    public UserModel(ServiceManager serviceManager, CacheManager cacheManager) {
        super(serviceManager, cacheManager);
        this.mCommonService = mServiceManager.getCommonService();
        this.mCommonCache = mCacheManager.getCommonCache();
    }


    @Override
    public Observable<List<User>> getUsers(int lastIdQueried, boolean update) {
        Observable<List<User>> users = mCommonService
                .getUsers(lastIdQueried, USERS_PER_PAGE);
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return mCommonCache
                .getUsers(users
                        ,new DynamicKey(lastIdQueried)
                        ,new EvictDynamicKey(update))
                .flatMap(new Func1<Reply<List<User>>, Observable<List<User>>>() {
                    @Override
                    public Observable<List<User>> call(Reply<List<User>> listReply) {
                        return Observable.just(listReply.getData());
                    }
                });
    }
}
