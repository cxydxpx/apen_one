package com.example.apen.onedemo.manager.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;
import com.example.apen.onedemo.bean.ArticleBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/11.
 */

public class ArticleManagerActivity extends BaseActivity {

    @BindView(R.id.include)
    RelativeLayout mInclude;

    @BindView(R.id.listview)
    ListView mListView;

    @Override
    protected void showView() {

    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_article_manager;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {

        View headView = View.inflate(this,R.layout.layout_lv_head,null);
        mListView.addHeaderView(headView);
        TextView tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("商品管理");
    }

    @Override
    protected void initData() {
        initArticleData();
    }

    private List<ArticleBean> datas = new ArrayList<>();

    private void initArticleData() {

        for (int i = 0; i < 20; i++) {
            datas.add(new ArticleBean("东北大米"+i,"万金商会"+i,"800斤"+i));
        }

    }

    @Override
    protected void initListener() {
        mListView.setAdapter(new IAdapter(datas));
    }

    @Override
    protected void processClick(View v) {

    }

    private class IAdapter extends BaseAdapter{

        private List<ArticleBean> datas;

        public IAdapter(List<ArticleBean> datas) {
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

                convertView = View.inflate(ArticleManagerActivity.this,R.layout.activity_article_manager_item,null);

                vh.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                vh.tv_shops_name = (TextView) convertView.findViewById(R.id.tv_shops_name);
                vh.tv_inventory = (TextView) convertView.findViewById(R.id.tv_inventory);

                convertView.setTag(vh);

            }else {
                vh = (ViewHolder) convertView.getTag();
            }

            ArticleBean articleBean = datas.get(position);

            vh.tv_name.setText(articleBean.getName());
            vh.tv_shops_name.setText(articleBean.getShops());
            vh.tv_inventory.setText(articleBean.getInventory());


            return convertView;
        }

        private final class ViewHolder{
            public TextView tv_name;
            public TextView tv_shops_name;
            public TextView tv_inventory;

        }

    }


}
