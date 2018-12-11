package com.bwie.zhaojunhui20181210.model;

import com.bwie.zhaojunhui20181210.bean.LoginBean;
import com.bwie.zhaojunhui20181210.bean.NewsBean;
import com.bwie.zhaojunhui20181210.bean.RegBean;
import com.bwie.zhaojunhui20181210.utils.HttpUtil;
import com.bwie.zhaojunhui20181210.utils.MyCallBack;

public class IModelImpl implements IModel {

    @Override
    public void setlogin(String url, final MyCallBack myCallback) {
        HttpUtil.getRequest(url, LoginBean.class, new HttpUtil.CallBack<LoginBean>() {
            @Override
            public void OnSuccess(LoginBean loginBean) {
                myCallback.onsetData(loginBean);
            }
        });
    }

    @Override
    public void setreg(String url, final MyCallBack myCallback) {
        HttpUtil.getRequest(url, RegBean.class, new HttpUtil.CallBack<RegBean>() {
            @Override
            public void OnSuccess(RegBean regBean) {
                myCallback.onsetData(regBean);
            }
        });
    }

    @Override
    public void setbanner(String url, final MyCallBack myCallback) {
        HttpUtil.getRequest(url, NewsBean.class, new HttpUtil.CallBack<NewsBean>() {
            @Override
            public void OnSuccess(NewsBean newsBean) {
                myCallback.onsetData(newsBean);
            }
        });
    }
}
