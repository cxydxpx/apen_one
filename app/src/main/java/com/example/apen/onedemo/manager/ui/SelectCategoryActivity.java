package com.example.apen.onedemo.manager.ui;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/10.
 */

public class SelectCategoryActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.include)
    RelativeLayout mInclude;
    private TextView tv;

    @Override
    protected int layoutResId() {
        return R.layout.activity_select_category;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        tv = (TextView) mInclude.findViewById(R.id.tv);
    }

    private List<String> datas = new ArrayList<>();

    @Override
    protected void initData() {
        tv.setText("选择分类");
        datas.add("鸡鸭海鲜");
        datas.add("水产海鲜");
        datas.add("猪副");
    }

    @Override
    protected void initListener() {
        listview.setAdapter(new IAdapter(datas));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectCategoryActivity.this, ManGoodsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void processClick(View v) {

    }

    public class IAdapter extends BaseAdapter {

        private List<String> datas;

        public IAdapter(List<String> datas) {
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
                convertView = View.inflate(SelectCategoryActivity.this, R.layout.activity_select_category_item, null);
                vh.tv = (TextView) convertView.findViewById(R.id.tv);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.tv.setText(datas.get(position));

            return convertView;
        }

        class ViewHolder {
            protected TextView tv;
        }
    }
}
