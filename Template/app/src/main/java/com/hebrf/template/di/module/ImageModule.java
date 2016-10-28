package com.hebrf.template.di.module;

import com.hebrf.template.mvp.ui.widget.imageloader.BaseImageLoaderStrategy;
import com.hebrf.template.mvp.ui.widget.imageloader.ImageLoader;
import com.hebrf.template.mvp.ui.widget.imageloader.glide.GlideImageLoaderStrategy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/10/24.
 */
@Module
public class ImageModule {

    @Singleton
    @Provides
    public BaseImageLoaderStrategy provideImageLoaderStrategy() {
        return new GlideImageLoaderStrategy();
    }

    @Singleton
    @Provides
    public ImageLoader provideImageLoader(BaseImageLoaderStrategy strategy) {
        return new ImageLoader(strategy);
    }
}
