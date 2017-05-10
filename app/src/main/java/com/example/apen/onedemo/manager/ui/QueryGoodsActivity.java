package com.example.apen.onedemo.manager.ui;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/10.
 */

public class QueryGoodsActivity extends BaseActivity {

    @BindView(R.id.include)
    RelativeLayout mInclude;
    private TextView tv;

    @Override
    protected int layoutResId() {
        return R.layout.activity_query_goods;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("查询商品");
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
