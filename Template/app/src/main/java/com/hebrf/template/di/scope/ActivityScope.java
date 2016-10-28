package com.hebrf.template.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2016/10/25.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {}
