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

    @BindView(R.id.tv_order)
    TextView mOrder;

    @BindView(R.id.tv_report)
    TextView mReport;

    @BindView(R.id.tv_sales)
    TextView mSales;

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
        mOrder.setOnClickListener(this);
        mReport.setOnClickListener(this);
    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.tv_place_order:
                Intent intent = new Intent(this, ManGoodsActivity.class);
                startActivity(intent);

                break;
            case R.id.tv_order:

                Intent intent1 = new Intent(this,OrderQueryActivity.class);
                startActivity(intent1);

                break;
            case R.id.tv_report:

                Intent intent2 = new Intent(this,ReportActivity.class);
                startActivity(intent2);

                break;
            case R.id.tv_sales:

                Intent intent3 = new Intent(this,SalesActivity.class);
                startActivity(intent3);

                break;
            default:
                break;
        }
    }
}
