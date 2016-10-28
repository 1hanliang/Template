package com.hebrf.template.mvp.ui.widget.imageloader.glide;

import android.app.Activity;
import android.content.Context;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hebrf.template.mvp.ui.widget.imageloader.BaseImageLoaderStrategy;

/**
 * Created by LYB on 2016/10/24.
 * Glide的图片加载策略,实现BaseImageLoaderStrategy接口
 */
public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy<GlideImageConfig> {
    @Override
    public void loadImage(Context ctx, GlideImageConfig config) {
        RequestManager manager = null;
        //如果是activity则可以使用Activity的生命周期
        if (ctx instanceof Activity)
            manager = Glide.with((Activity) ctx);
        else
            manager = Glide.with(ctx);

        DrawableRequestBuilder<String> requestBuilder = manager.load(config.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop();
        if (config.getPlaceholder() != 0)//设置占位符
            requestBuilder.placeholder(config.getPlaceholder());

        if (config.getErrorPic() != 0)//设置错误的图片
            requestBuilder.error(config.getErrorPic());

        requestBuilder
                .into(config.getImageView());
    }
}
