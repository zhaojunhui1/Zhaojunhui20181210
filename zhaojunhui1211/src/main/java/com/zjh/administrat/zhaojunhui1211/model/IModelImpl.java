package com.zjh.administrat.zhaojunhui1211.model;

import com.zjh.administrat.zhaojunhui1211.bean.UserBean;
import com.zjh.administrat.zhaojunhui1211.util.MyCallBack;
import com.zjh.administrat.zhaojunhui1211.util.OkHttpUtil;

public class IModelImpl implements IModel {


    @Override
    public void mshowData(String url, Class clazz, final MyCallBack myCallBack) {
        OkHttpUtil.getRequest(url, UserBean.class, new OkHttpUtil.CallBack(){
            @Override
            public void OnSuccess(Object data) {
                myCallBack.callData(data);
            }
        });
    }

}
