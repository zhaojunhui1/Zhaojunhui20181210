package com.zjh.administrat.zhaojunhui1211.presenter;

import com.zjh.administrat.zhaojunhui1211.bean.UserBean;
import com.zjh.administrat.zhaojunhui1211.model.IModelImpl;
import com.zjh.administrat.zhaojunhui1211.util.MyCallBack;
import com.zjh.administrat.zhaojunhui1211.view.IView;

public class IPresenterImpl implements IPresenter {

    private IView iView;
    private IModelImpl iModel;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void pshowData(String url) {
        iModel.mshowData(url, UserBean.class, new MyCallBack() {
            @Override
            public void callData(Object data) {
                iView.showData(data);
            }
        });
    }


    public void onDetach(){
        if (iView != null){
            iView = null;
        }
        if (iModel != null){
            iModel = null;
        }
    }

}
