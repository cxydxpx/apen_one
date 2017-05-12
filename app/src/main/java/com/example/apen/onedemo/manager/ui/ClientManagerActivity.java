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
import com.example.apen.onedemo.bean.ClientBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/11.
 */

public class ClientManagerActivity extends BaseActivity {

    @BindView(R.id.include)
    RelativeLayout mInclude;

    @BindView(R.id.listview)
    ListView mListView;

    @BindView(R.id.btn_add)
    Button mAdd;

    private TextView tv1;
    private TextView tv;

    @Override
    protected void showView() {

    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_client_manager;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {

        View headView = View.inflate(this, R.layout.layout_lv_head, null);
        headView.findViewById(R.id.tv_inventory).setVisibility(View.GONE);
        tv = (TextView) headView.findViewById(R.id.tv_name);
        mListView.addHeaderView(headView);
        tv1 = (TextView) mInclude.findViewById(R.id.tv);
    }

    @Override
    protected void initData() {
        tv1.setText("客户单位");
        tv.setText("商品管理");
        initClientData();
    }

    private List<ClientBean> datas = new ArrayList<>();

    private void initClientData() {
        for (int i = 0; i < 20; i++) {
            datas.add(new ClientBean("测试用户"+i,"批发客户"+i));
        }
    }

    @Override
    protected void initListener() {
        mInclude.findViewById(R.id.rl_back).setOnClickListener(this);
        mAdd.setOnClickListener(this);
        mListView.setAdapter(new IAdapter(datas));
    }
    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                Intent intent = new Intent(this,NewAddClientActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private class IAdapter extends BaseAdapter {

        private List<ClientBean> datas;

        public IAdapter(List<ClientBean> datas) {
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

                convertView = View.inflate(ClientManagerActivity.this, R.layout.activity_client_manager_item, null);

                vh.tv_name = (TextView) convertView.findViewById(R.id.tv_name);

                convertView.setTag(vh);

            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            ClientBean clientBean = datas.get(position);

            vh.tv_name.setText(clientBean.getName()+" "+clientBean.getType());

            return convertView;
        }

        private final class ViewHolder {
            public TextView tv_name;

        }

    }

}
