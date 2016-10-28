package com.hebrf.template.mvp.ui.widget.imageloader;

import android.content.Context;

/**
 * Created by LYB on 2016/10/24.
 * 图片加载类
 * (要不要考虑单例模式呢?)
 */
public class ImageLoader {
    private BaseImageLoaderStrategy mStrategy;

    public ImageLoader(BaseImageLoaderStrategy strategy) {
        setLoadImgStrategy(strategy);
    }

    /**
     * 加载图片
     * @param context
     * @param config
     * @param <T>
     */
    public <T extends ImageConfig> void loadImage(Context context, T config) {
        this.mStrategy.loadImage(context, config);
    }

    /**
     * 设置加载策略
     * @param strategy
     */
    public void setLoadImgStrategy(BaseImageLoaderStrategy strategy) {
        this.mStrategy = strategy;
    }
}
