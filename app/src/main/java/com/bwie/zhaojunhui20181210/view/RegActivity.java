package com.bwie.zhaojunhui20181210.view;

import android.content.Intent;
import android.support.annotation.StyleableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bwie.zhaojunhui20181210.R;
import com.bwie.zhaojunhui20181210.bean.RegBean;
import com.bwie.zhaojunhui20181210.presenter.IPresenter;
import com.bwie.zhaojunhui20181210.presenter.IPresenterImpl;

public class RegActivity extends AppCompatActivity implements IView{

    private EditText name, pass;
    private String username1;
    private String password1;
    private String path = "http://www.zhaoapi.cn/user/reg?mobile=%s&password=%s";
    private IPresenterImpl iPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        name = findViewById(R.id.name1);
        pass = findViewById(R.id.pass1);
        iPresenter = new IPresenterImpl(this);

        //点击注册按钮
        findViewById(R.id.zhuce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username1 = name.getText().toString();
                password1 = pass.getText().toString();
                iPresenter.preg(String.format(path, username1, password1));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onDetouch();
    }
    @Override
    public void viewData(Object data) {
        RegBean regBean = (RegBean) data;
        if(regBean.getMsg().equals("注册成功")){
            startActivity(new Intent(RegActivity.this, MainActivity.class));
        }
    }
}
