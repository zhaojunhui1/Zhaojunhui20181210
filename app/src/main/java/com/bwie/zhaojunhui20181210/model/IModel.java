package com.bwie.zhaojunhui20181210.model;

import com.bwie.zhaojunhui20181210.utils.MyCallBack;

public interface IModel<T> {
    void setlogin(String url, MyCallBack myCallback);
    void setreg(String url, MyCallBack myCallback);
    void setbanner(String url, MyCallBack myCallback);
}
