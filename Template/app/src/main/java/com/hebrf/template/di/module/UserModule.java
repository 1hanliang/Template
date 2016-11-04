package com.hebrf.template.di.module;

import com.hebrf.template.contract.UserContract;
import com.hebrf.template.di.scope.ActivityScope;
import com.hebrf.template.mvp.model.UserModel;
import com.hebrf.template.mvp.model.api.cache.CacheManager;
import com.hebrf.template.mvp.model.api.service.ServiceManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/10/25.
 */
@Module
public class UserModule {
    private UserContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public UserModule(UserContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    UserContract.View provideUserView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    UserContract.Model provideUserModel(ServiceManager serviceManager, CacheManager cacheManager){
        return new UserModel(serviceManager,cacheManager);
    }

}

