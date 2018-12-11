package com.zjh.administrat.zhaojunhui1211.view;

import android.Manifest;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;
import com.zjh.administrat.zhaojunhui1211.R;
import com.zjh.administrat.zhaojunhui1211.bean.UserBean;
import com.zjh.administrat.zhaojunhui1211.presenter.IPresenterImpl;

public class MainActivity extends AppCompatActivity implements IView {

    private String url = "http://www.zhaoapi.cn/ad/getAd";
    private IPresenterImpl iPresenter;
    private ListView listView;
    private UserAdapter mAdapter;
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        banner = findViewById(R.id.banner);
        mAdapter = new UserAdapter(this);
        listView.setAdapter(mAdapter);
        iPresenter = new IPresenterImpl(this);
        iPresenter.pshowData(url);
    }

    @Override
    public void showData(Object data) {
        UserBean userBean = (UserBean) data;
        mAdapter.setDatas(userBean.getData());
        Toast.makeText(MainActivity.this, "" + userBean, Toast.LENGTH_SHORT).show();

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                UserBean.DataBean mBanner = (UserBean.DataBean) path;
                ImageLoader.getInstance().displayImage(mBanner.getIconHttp(), imageView);
            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
        banner.setImages(userBean.getData());
        banner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onDetach();
    }
}
