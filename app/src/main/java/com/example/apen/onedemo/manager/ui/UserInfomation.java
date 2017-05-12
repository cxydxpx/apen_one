package com.example.apen.onedemo.manager.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/10.
 */

public class UserInfomation extends BaseActivity {

    @BindView(R.id.include)
    RelativeLayout mInclude;

    @BindView(R.id.btn_submit)
    Button mSubmit;

    @Override
    protected void showView() {

    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_user_infomation;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        TextView tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("选择送货信息");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mSubmit.setOnClickListener(this);
    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                Intent intent = new Intent(this, AddressActivity.class);
                startActivity(intent);
                break;
        }
    }
}
