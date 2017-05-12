package com.example.apen.onedemo.manager.ui;

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

public class AddressActivity extends BaseActivity {

    @BindView(R.id.btn_submit)
    Button mSubmit;
    @BindView(R.id.include)
    RelativeLayout mInclude;
    private TextView tv;

    @Override
    protected void showView() {

    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_address;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("新增收货地址");
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

                finish();

                break;
        }
    }
}
