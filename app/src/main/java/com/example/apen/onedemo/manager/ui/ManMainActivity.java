package com.example.apen.onedemo.manager.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/9.
 */

public class ManMainActivity extends BaseActivity {

    @BindView(R.id.tv_place_order)
    TextView mPlaceOrder;

    @Override
    protected int layoutResId() {
        return R.layout.activity_man_main;
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
        mPlaceOrder.setOnClickListener(this);
    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.tv_place_order:
                Intent intent = new Intent(this,ManGoodsActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
