package com.bwie.zhaojunhui20181210.utils;

import android.app.Application;

import com.bwie.zhaojunhui20181210.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //图片展示
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(50)
                .diskCacheSize(50*1024*1024)
                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                        .cacheOnDisk(true)
                        .cacheInMemory(true)
                        .showImageOnFail(R.mipmap.ic_launcher)
                        .showImageOnLoading(R.mipmap.ic_launcher)
                        .showImageForEmptyUri(R.mipmap.ic_launcher)
                        .build())
                .build());


        //QQ第三方登录
        UMConfigure.init(this,"5a12384aa40fa3551f0001d1","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

    }
}
