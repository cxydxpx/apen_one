package com.example.apen.onedemo.manager.ui;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;
import com.example.apen.onedemo.bean.Goods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/10.
 */

public class SubmitOrderActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView mListView;

    @BindView(R.id.include)
    RelativeLayout mInclude;

    @BindView(R.id.rl_infomation)
    RelativeLayout mInfomation;

    @BindView(R.id.btn_submit)
    Button mSubmit;

    private TextView tv;

    @Override
    protected void showView() {

    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_submit_order;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("提交订单");
    }

    @Override
    protected void initData() {
        initGoods();
    }

    private List<Goods> datas = new ArrayList<>();

    private void initGoods() {

        for (int i = 0; i < 3; i++) {
            Goods goods = new Goods("鸡翅" + i, "14箱" + i, "￥20" + i);
            datas.add(goods);
        }

        datas.add(new Goods("合计 ：￥ 1024"));

    }

    @Override
    protected void initListener() {

        mInclude.findViewById(R.id.rl_back).setOnClickListener(this);

        mSubmit.setOnClickListener(this);
        mInfomation.setOnClickListener(this);

        mListView.setAdapter(new IAdapter(datas));
    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.rl_infomation:

                Intent intent = new Intent(this,UserInfomation.class);
                startActivity(intent);
                break;
            case R.id.btn_submit:
                Intent intent1 = new Intent(this,CashActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }

    class IAdapter extends BaseAdapter {

        private List<Goods> datas;

        public IAdapter(List<Goods> datas) {
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder vh = null;
            if (convertView == null) {
                vh = new ViewHolder();
                convertView = View.inflate(SubmitOrderActivity.this, R.layout.activity_submit_order_item, null);
                vh.mName = (TextView) convertView.findViewById(R.id.tv_name);
                vh.mWeight = (TextView) convertView.findViewById(R.id.tv_weight);
                vh.mPrice = (TextView) convertView.findViewById(R.id.tv_price);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }


            Goods goods = datas.get(position);

            vh.mName.setText(goods.getName());
            vh.mWeight.setText(goods.getWeight());
            vh.mPrice.setText(goods.getPrice());

            return convertView;
        }

        class ViewHolder {
            private TextView mName;
            private TextView mWeight;
            private TextView mPrice;
        }
    }

}
