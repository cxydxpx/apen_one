package com.example.apen.onedemo;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.apen.onedemo.manager.ui.ManMainActivity;

import butterknife.OnClick;

/**
 * 引导页面
 */
public class FlushActivity extends BaseActivity {

    @OnClick(R.id.btn_manager)
    void btn_manager() {
        Toast.makeText(this, "服务端", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ManMainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_client)
    void btn_client() {
        Toast.makeText(this, "客户端", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_flush;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void processClick(View v) {
    }
}
