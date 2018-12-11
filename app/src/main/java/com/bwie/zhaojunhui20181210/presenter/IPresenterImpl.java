package com.bwie.zhaojunhui20181210.presenter;

import com.bwie.zhaojunhui20181210.model.IModelImpl;
import com.bwie.zhaojunhui20181210.utils.MyCallBack;
import com.bwie.zhaojunhui20181210.view.IView;

public class IPresenterImpl implements IPresenter{

    private IView iView;
    private IModelImpl iModel;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void plogin(String url) {
         iModel.setlogin(url, new MyCallBack() {
             @Override
             public void onsetData(Object data) {
                 iView.viewData(data);
             }
         });
    }

    @Override
    public void preg(String url) {
        iModel.setreg(url, new MyCallBack() {
            @Override
            public void onsetData(Object data) {
                iView.viewData(data);
            }
        });
    }

    @Override
    public void pbanner(String url) {
        iModel.setbanner(url, new MyCallBack() {
            @Override
            public void onsetData(Object data) {
                iView.viewData(data);
            }
        });
    }

    public void onDetouch() {
        if (iView != null) {
            iView = null;
        }
        if (iModel != null) {
            iModel = null;
        }
    }
}
