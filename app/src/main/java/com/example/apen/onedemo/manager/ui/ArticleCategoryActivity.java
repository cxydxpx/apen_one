package com.example.apen.onedemo.manager.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
 * Created by Administrator on 2017/5/11.
 */

public class ArticleCategoryActivity extends BaseActivity{

    @BindView(R.id.include)
    RelativeLayout mInclude;

    @BindView(R.id.listview)
    ListView mListView;

    @Override
    protected int layoutResId() {
        return R.layout.activity_article_category;
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
    private List<Goods> datas = new ArrayList<>();
    private void initArticleData() {
        for (int i = 0; i < 20; i++) {
            datas.add(new Goods("东北大米"+i));
        }
    }

    @Override
    protected void initListener() {
        mListView.setAdapter(new IAdapter(datas));
    }

    @Override
    protected void processClick(View v) {

    }

    private class IAdapter extends BaseAdapter {

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

            if (convertView == null){

                vh = new ViewHolder();

                convertView = View.inflate(ArticleCategoryActivity.this,R.layout.activity_article_category_item,null);

                vh.tv_name = (TextView) convertView.findViewById(R.id.tv_name);

                convertView.setTag(vh);

            }else {
                vh = (ViewHolder) convertView.getTag();
            }

            Goods goods = datas.get(position);

            vh.tv_name.setText(goods.getName());

            return convertView;
        }

        private final class ViewHolder{
            public TextView tv_name;

        }

    }

}
