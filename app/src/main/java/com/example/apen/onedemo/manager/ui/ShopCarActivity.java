package com.example.apen.onedemo.manager.ui;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;
import com.example.apen.onedemo.bean.ShopCarBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/10.
 */

public class ShopCarActivity extends BaseActivity {

    @BindView(R.id.include)
    RelativeLayout mInclude;

    @BindView(R.id.listview)
    ListView mListView;

    @BindView(R.id.btn_submit)
    Button mSubmit;

    private TextView tv;

    @Override
    protected int layoutResId() {
        return R.layout.activity_shop_car;
    }

    @Override
    protected void init() {
        tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("购物车");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        initShopData();
    }

    private List<ShopCarBean> datas = new ArrayList();

    private void initShopData() {
        for (int i = 0; i < 20; i++) {
            ShopCarBean bean = new ShopCarBean("鸡翅", "包", i, (double) i);
            datas.add(bean);
        }

    }

    @Override
    protected void initListener() {
        mListView.setAdapter(new IAdapter(datas));

        mSubmit.setOnClickListener(this);

    }

    @Override
    protected void processClick(View v) {

        switch (v.getId()) {
            case R.id.btn_submit:

                Intent intent = new Intent(this,SubmitOrderActivity.class);
                startActivity(intent);

                break;
        }

    }

    protected class IAdapter extends BaseAdapter {

        private List<ShopCarBean> datas;

        public IAdapter(List<ShopCarBean> datas) {
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
            if (convertView == null){
                vh = new ViewHolder();
                convertView = View.inflate(ShopCarActivity.this,R.layout.activity_shop_car_item,null);
                vh.name = (TextView) convertView.findViewById(R.id.tv_name);
                vh.type = (TextView) convertView.findViewById(R.id.tv_type);
                vh.delete = (Button) convertView.findViewById(R.id.btn_delete);
                vh.tvNumber = (TextView) convertView.findViewById(R.id.tv_number);
                vh.tvPrice = (TextView) convertView.findViewById(R.id.tv_price);
                vh.number = (EditText) convertView.findViewById(R.id.et_number);
                vh.price = (EditText) convertView.findViewById(R.id.et_price);

                convertView.setTag(vh);
            }else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.tvNumber.setText("数量");
            vh.tvPrice.setText("单价");

            ShopCarBean bean = datas.get(position);

            vh.name.setText(bean.getName());
            vh.type.setText(bean.getType());

            vh.number.setText(bean.getNumber()+"");
            vh.price.setText(bean.getPrice()+"");
            return convertView;
        }

        class ViewHolder{
            public TextView name;
            public TextView type;
            public Button delete;
            public TextView tvNumber;
            public TextView tvPrice;
            public EditText number;
            public EditText price;
        }

    }

}
