package com.hebrf.template.di.commponent;

import com.hebrf.template.di.module.UserModule;
import com.hebrf.template.di.scope.ActivityScope;
import com.hebrf.template.mvp.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by Administrator on 2016/10/26.
 */
@ActivityScope
@Component(modules = UserModule.class,dependencies = AppComponent.class)
public interface UserComponent {
    void inject(MainActivity activity);
}

