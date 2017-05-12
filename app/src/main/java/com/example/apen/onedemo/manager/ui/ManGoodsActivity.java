package com.example.apen.onedemo.manager.ui;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;
import com.example.apen.onedemo.bean.Goods;
import com.example.apen.onedemo.utils.DividerGridItemDecoration;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/10.
 * 其实就是从仓库调去货物发出出去的一个功能
 */

public class ManGoodsActivity extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    @BindView(R.id.tv_category)
    TextView mCategory;

    @BindView(R.id.tv_query)
    TextView mQuery;

    @BindView(R.id.tv_shop_car)
    TextView mShopCar;

    @BindView(R.id.include)
    RelativeLayout mInclude;

    private TextView tv;


    @Override
    protected int layoutResId() {
        return R.layout.activity_man_goods;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        tv = (TextView) mInclude.findViewById(R.id.tv);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }

    @Override
    protected void initData() {
        tv.setText("商品");
        initRecyclerData();
    }

    private List<Goods> goodsDatas = new ArrayList<>();

    private void initRecyclerData() {

        for (int i = 0; i < 20; i++) {
            Goods goods = new Goods("猪舌头 " + i, "20斤 " + i, "￥800.00/箱 " + i);
            goodsDatas.add(goods);
        }

    }

    @Override
    protected void showView() {

    }

    @Override
    protected void initListener() {
        mInclude.findViewById(R.id.rl_back).setOnClickListener(this);
        mCategory.setOnClickListener(this);
        mQuery.setOnClickListener(this);
        mShopCar.setOnClickListener(this);

        CommonAdapter commonAdapter = new CommonAdapter<Goods>(this, R.layout.activity_man_goods_item, goodsDatas) {
            @Override
            protected void convert(ViewHolder holder, Goods goods, int position) {
                TextView mName = holder.getView(R.id.tv_name);
                TextView mWeight = holder.getView(R.id.tv_weight);
                TextView mPrice = holder.getView(R.id.tv_price);

                mName.setText(goods.getName());
                mWeight.setText(goods.getWeight());
                mPrice.setText(goods.getPrice());

            }
        };
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        mRecyclerView.setAdapter(commonAdapter);
    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.tv_category:
                Intent intent = new Intent(this, SelectCategoryActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_query:
                Intent intent1 = new Intent(this, QueryGoodsActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_shop_car:
                Intent intent2 = new Intent(this, ShopCarActivity.class);
                startActivity(intent2);

                break;
            default:
                break;
        }
    }

}
