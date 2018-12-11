package com.bwie.zhaojunhui20181210.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.zhaojunhui20181210.R;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanActivity extends AppCompatActivity implements QRCodeView.Delegate {

    private ZXingView mZXingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        mZXingView = findViewById(R.id.zxingView);
        mZXingView.setDelegate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mZXingView.startCamera();
        mZXingView.startSpotAndShowRect();
        mZXingView.openFlashlight();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mZXingView.stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mZXingView.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {

    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}
