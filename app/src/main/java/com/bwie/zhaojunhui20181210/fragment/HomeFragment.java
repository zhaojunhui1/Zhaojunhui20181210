package com.bwie.zhaojunhui20181210.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bwie.zhaojunhui20181210.R;
import com.bwie.zhaojunhui20181210.bean.LoginBean;
import com.bwie.zhaojunhui20181210.bean.NewsBean;
import com.bwie.zhaojunhui20181210.presenter.IPresenterImpl;
import com.bwie.zhaojunhui20181210.view.IView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

public class HomeFragment extends android.support.v4.app.Fragment implements IView {

    private ListView listView;
    private IPresenterImpl iPresenter;
    private String path = "http://api.tianapi.com/wxnew/?key=c4aa776e0a51d57d6750511e2baa46b6&num=6&page=1";
    private Banner banner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.homefragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);
        banner = view.findViewById(R.id.banner);
        iPresenter = new IPresenterImpl(this);
        iPresenter.pbanner(path);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (iPresenter != null) {
            iPresenter.onDetouch();
        }
    }

    @Override
    public void viewData(Object data) {
        initBanner(data);
        /*NewsBean newsBean = (NewsBean) data;
        List<NewsBean.DataBean.BannerBean> mBanner = newsBean.getData().getBanner();
        Toast.makeText(getActivity(),mBanner+"",Toast.LENGTH_SHORT).show();

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图图片的加载器
        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                NewsBean.DataBean.BannerBean mBanner = (NewsBean.DataBean.BannerBean) path;
                ImageLoader.getInstance().displayImage(mBanner.getUrl(), imageView);
            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
        initData(mBanner);
    }

    private void initData(List<NewsBean.DataBean.BannerBean> mBanner) {
        banner.setImages(mBanner);
        banner.setBannerTitles(getTitles(mBanner));
        banner.start();
    }

    private List<String> getTitles(List<NewsBean.DataBean.BannerBean> mBanner) {
        List<String> result = new ArrayList<>();
        for (NewsBean.DataBean.BannerBean banner : mBanner) {
            result.add(banner.getTitle());
        }
        return result;*/
    }

    private void initBanner(Object data) {
        NewsBean bannerBean = (NewsBean) data;

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                NewsBean.DataBean.BannerBean bean = (NewsBean.DataBean.BannerBean) path;
                ImageLoader.getInstance().displayImage(bean.getUrl(), imageView);
            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });

        banner.setImages(bannerBean.getData().getBanner());
        banner.start();
    }


}
