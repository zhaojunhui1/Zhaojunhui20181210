package com.bwie.zhaojunhui20181210.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.zhaojunhui20181210.R;
import com.bwie.zhaojunhui20181210.bean.LoginBean;
import com.bwie.zhaojunhui20181210.presenter.IPresenter;
import com.bwie.zhaojunhui20181210.presenter.IPresenterImpl;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView{
    private EditText name, pass;
    private IPresenterImpl iPresenter;
    private String path = "http://www.zhaoapi.cn/user/login?mobile=%s&password=%s";
    private String password;
    private String username;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //原生登录
        initView();
        //创建中间层
        iPresenter = new IPresenterImpl(this);
        //昵称生成
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String name1 = sharedPreferences.getString("name1", null);

    }

    //原生登录
    private void initView() {
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        //点击登录按钮
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = name.getText().toString();
                password = pass.getText().toString();
                iPresenter.plogin(String.format(path, username, password));
            }
        });

        //点击注册按钮跳转
        findViewById(R.id.reg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegActivity.class));
            }
        });

        //umeng第三方
        findViewById(R.id.qq_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI umShareAPI =  UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        //获取名字
                        String name  = map.get("screen_name");
                        editor.putString("name", name);
                        editor.commit();
                        //获取头像
                        String img  = map.get("profile_image_url");
                        //登录完成跳转详情页
                        startActivity(new Intent(MainActivity.this, DetailsActivity.class));

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
            }
        });

    }


    @Override
    public void viewData(Object data) {
        LoginBean loginBean = (LoginBean) data;
        Toast.makeText(MainActivity.this,""+loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        if (loginBean.getMsg().equals("登录成功")) {
            startActivity(new Intent(MainActivity.this, DetailsActivity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onDetouch();
    }
}
