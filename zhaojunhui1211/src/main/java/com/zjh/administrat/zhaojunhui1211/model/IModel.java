package com.zjh.administrat.zhaojunhui1211.model;

import com.zjh.administrat.zhaojunhui1211.util.MyCallBack;

public interface IModel<T> {
    void mshowData(String url, Class clazz, MyCallBack myCallBack);
}
