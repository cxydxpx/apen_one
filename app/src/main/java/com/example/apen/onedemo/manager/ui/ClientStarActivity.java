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

public class ClientStarActivity extends BaseActivity{
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
        return R.layout.activity_client_star;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        TextView tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("客户星级");
    }

    @Override
    protected void initData() {
        initArticleData();
    }

    private List<ClientBean> datas = new ArrayList<>();

    private void initArticleData() {
            datas.add(new ClientBean("批发客户"));
            datas.add(new ClientBean("零售业"));
            datas.add(new ClientBean("大户"));

    }

    @Override
    protected void initListener() {

        mInclude.findViewById(R.id.rl_back).setOnClickListener(this);
        mListView.setAdapter(new IAdapter(datas));
        mAdd.setOnClickListener(this);

    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:

               Intent intent = new Intent(this,NewAddStarActivity.class);
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

            if (convertView == null){

                vh = new ViewHolder();

                convertView = View.inflate(ClientStarActivity.this,R.layout.activity_client_star_item,null);

                vh.tv_name = (TextView) convertView.findViewById(R.id.tv_name);

                convertView.setTag(vh);

            }else {
                vh = (ViewHolder) convertView.getTag();
            }

            ClientBean articleBean = datas.get(position);

            vh.tv_name.setText(articleBean.getName());


            return convertView;
        }

        private final class ViewHolder{
            public TextView tv_name;

        }

    }
}
