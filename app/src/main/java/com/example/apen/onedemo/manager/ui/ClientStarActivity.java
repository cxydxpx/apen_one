package com.example.apen.onedemo.manager.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        tv.setText("商品管理");
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
        mListView.setAdapter(new IAdapter(datas));
    }

    @Override
    protected void processClick(View v) {

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
