package com.hebrf.template.mvp.ui.widget.imageloader;

import android.content.Context;

/**
 * Created by LYB on 2016/10/24.
 * 图片加载策略者模式
 * (主要解决图片加载框架的选择,增强架构弹性,选择困难症的误入......)
 */
public interface BaseImageLoaderStrategy<T extends ImageConfig>  {
    /**
     * 图片加载
     * @param ctx 上下文
     * @param config 配置项
     */
    void loadImage(Context ctx, T config);

}
