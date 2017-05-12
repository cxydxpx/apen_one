package com.example.apen.onedemo.manager.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;

import butterknife.BindView;

public class MaLoginActivity extends BaseActivity {

    @BindView(R.id.btn_login)
    Button mLogin;

    @Override
    protected void showView() {

    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_manlogin;
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
        mLogin.setOnClickListener(this);
    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                Intent intent = new Intent(this,ManMainActivity.class);

                break;
            default:
                break;
        }
    }
}
