package com.example.apen.onedemo.manager.ui;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/12.
 */

public class NewAddClientActivity extends BaseActivity{

    @BindView(R.id.include)
    RelativeLayout mInclude;

    @Override
    protected int layoutResId() {
        return R.layout.activity_new_add_client;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        TextView tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("新增客户");
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initListener() {
        mInclude.findViewById(R.id.rl_back).setOnClickListener(this);
    }

    @Override
    protected void showView() {

    }

    @Override
    protected void processClick(View v) {

    }
}
