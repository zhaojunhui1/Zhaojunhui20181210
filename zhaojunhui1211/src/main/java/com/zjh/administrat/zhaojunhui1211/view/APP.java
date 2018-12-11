package com.zjh.administrat.zhaojunhui1211.view;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zjh.administrat.zhaojunhui1211.R;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
                .diskCacheSize(50*102481024)
                .memoryCacheSizePercentage(50)
                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .showImageForEmptyUri(R.mipmap.ic_launcher)
                        .showImageOnFail(R.mipmap.ic_launcher)
                        .showImageOnLoading(R.mipmap.ic_launcher)
                        .build())
                .build());
    }
}
