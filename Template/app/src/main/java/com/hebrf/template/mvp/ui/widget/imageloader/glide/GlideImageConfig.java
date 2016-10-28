package com.hebrf.template.mvp.ui.widget.imageloader.glide;

import android.widget.ImageView;

import com.hebrf.template.mvp.ui.widget.imageloader.ImageConfig;

/**
 * Created by LYB on 2016/10/24.
 * 图片加载配置
 */
public class GlideImageConfig extends ImageConfig {

    private GlideImageConfig(Buidler builder) {
        this.url = builder.url;
        this.imageView = builder.imageView;
        this.placeholder = builder.placeholder;
        this.errorPic = builder.errorPic;
    }

    public static Buidler builder() {
        return new Buidler();
    }


    public static final class Buidler {
        private String url;
        private ImageView imageView;
        private int placeholder;
        protected int errorPic;

        private Buidler() {
        }

        /**
         * 设置url
         * @param url
         * @return
         */
        public Buidler url(String url) {
            this.url = url;
            return this;
        }

        /**
         * 设置占位符
         * @param placeholder
         * @return
         */
        public Buidler placeholder(int placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        /**
         * 设置加载异常
         * @param errorPic
         * @return
         */
        public Buidler errorPic(int errorPic){
            this.errorPic = errorPic;
            return this;
        }

        /**
         * 设置ImageView
         * @param imageView
         * @return
         */
        public Buidler imagerView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public GlideImageConfig build() {
            if (url == null) throw new IllegalStateException("必须有url路径");
            if (imageView == null) throw new IllegalStateException("必须有ImageView");
            return new GlideImageConfig(this);
        }
    }
}

