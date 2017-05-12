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
import com.example.apen.onedemo.bean.VendorBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/11.
 */

public class VendorManagerActivity extends BaseActivity{


    @BindView(R.id.include)
    RelativeLayout mInclude;

    @BindView(R.id.listview)
    ListView mListView;

    @BindView(R.id.btn_add)
    Button mAdd;

    @Override
    protected void showView() {

    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_vendor_manager;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {

        View headView = View.inflate(this,R.layout.layout_lv_head,null);
        headView.findViewById(R.id.tv_inventory).setVisibility(View.GONE);
        mListView.addHeaderView(headView);
        TextView tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("供应商管理");
    }

    @Override
    protected void initData() {
        initArticleData();
    }

    private List<VendorBean> datas = new ArrayList<>();

    private void initArticleData() {

        for (int i = 0; i < 20; i++) {
            datas.add(new VendorBean("马总"+i,"1523926272"+i,"双汇"+i));
        }

    }

    @Override
    protected void initListener() {
        mAdd.setOnClickListener(this);
        mListView.setAdapter(new IAdapter(datas));
    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:

                Intent intent = new Intent(this,NewAddVendorActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private class IAdapter extends BaseAdapter {

        private List<VendorBean> datas;

        public IAdapter(List<VendorBean> datas) {
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

                convertView = View.inflate(VendorManagerActivity.this,R.layout.activity_vendor_manager_item,null);

                vh.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                vh.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);
                vh.tv_article = (TextView) convertView.findViewById(R.id.tv_article_name);

                convertView.setTag(vh);

            }else {
                vh = (ViewHolder) convertView.getTag();
            }

            VendorBean vendorBean = datas.get(position);

            vh.tv_name.setText(vendorBean.getName());
            vh.tv_phone.setText(vendorBean.getPhone());
            vh.tv_article.setText(vendorBean.getArticle());

            return convertView;
        }

        private final class ViewHolder{
            public TextView tv_name;
            public TextView tv_phone;
            public TextView tv_article;

        }

    }


}
