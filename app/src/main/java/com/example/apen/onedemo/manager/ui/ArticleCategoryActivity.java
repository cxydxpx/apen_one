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
 * Created by Administrator on 2017/5/11.
 */

public class ArticleCategoryActivity extends BaseActivity{

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
        return R.layout.activity_article_category;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        TextView tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("商品分类");
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
        mInclude.findViewById(R.id.rl_back).setOnClickListener(this);
        mAdd.setOnClickListener(this);
        mListView.setAdapter(new IAdapter(datas));

    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:

                Intent intent = new Intent(this,NewAddCategoryActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
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
