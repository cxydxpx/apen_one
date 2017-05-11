package com.example.apen.onedemo.manager.ui;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/9.
 */

public class ManMainActivity extends BaseActivity {


    @BindView(R.id.rl_article_manager)
    RelativeLayout mArticleManager;

    @BindView(R.id.rl_article_category)
    RelativeLayout mArticleCategory;

    @BindView(R.id.rl_vendor_manager)
    RelativeLayout mVendorManager;

    @BindView(R.id.rl_client_manager)
    RelativeLayout mClientManager;

    @BindView(R.id.rl_client_star)
    RelativeLayout mClientStar;

    @BindView(R.id.rl_exit)
    RelativeLayout mExit;

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

        mArticleManager.setOnClickListener(this);
        mArticleCategory.setOnClickListener(this);
        mVendorManager.setOnClickListener(this);
        mClientManager.setOnClickListener(this);
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
            case R.id.rl_article_manager:

                Intent intent4 = new Intent(this,ArticleManagerActivity.class);
                startActivity(intent4);

                break;
            case R.id.rl_article_category:
                Intent intent5 = new Intent(this,ArticleCategoryActivity.class);
                startActivity(intent5);
            case R.id.rl_vendor_manager:

                Intent intent6 = new Intent(this,VendorManagerActivity.class);
                startActivity(intent6);

                break;

            case R.id.rl_client_manager:
                Intent intent7 = new Intent(this,ClientManagerActivity.class);
                startActivity(intent7);
                break;

            default:
                break;
        }
    }
}
