package com.hebrf.template.mvp.ui.widget.imageloader;

import android.widget.ImageView;

/**
 * Created by LYB on 2016/10/24.
 * 图片加载的配置信息
 * (采用策略模式:让你知道为什么java是世界最好的语言,
 * java大法好,java大法万岁)
 */
public class ImageConfig {
    protected String url;//图片的url网址
    protected ImageView imageView;//图片组件
    protected int placeholder;//占位符
    protected int errorPic;//加载图片异常


    public String getUrl() {
        return url;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public int getErrorPic() {
        return errorPic;
    }
}
