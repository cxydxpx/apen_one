package com.example.apen.onedemo.manager.ui;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;
import com.example.apen.onedemo.bean.ReportBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

import static com.example.apen.onedemo.utils.AppUtils.getTime;

/**
 * Created by Administrator on 2017/5/10.
 */

public class ReportActivity extends BaseActivity {

    @BindView(R.id.include)
    RelativeLayout mInclude;

    @BindView(R.id.tv_query_start)
    TextView mQueryStart;

    @BindView(R.id.tv_query_stop)
    TextView mQueryStop;

    @BindView(R.id.btn_query)
    Button mQuery;

    @BindView(R.id.listview)
    ListView mListView;
    private TimePickerView pvTime, pvTime2;

    @Override
    protected void showView() {

    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_report;
    }

    @Override
    protected void init() {
        initTimePicker();
        initTimePicker1();
    }

    private void initTimePicker1() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2013, 0, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2019, 11, 28);
        pvTime2 = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                TextView btn = (TextView) v;
                btn.setText(getTime(date));
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .build();
    }

    private void initTimePicker() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2013, 0, 23);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2019, 11, 28);
        //时间选择器
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null

                /*btn_Time.setText(getTime(date));*/
                TextView btn = (TextView) v;
                btn.setText(getTime(date));
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .build();
    }

    @Override
    protected void initView() {

        TextView tv = (TextView) mInclude.findViewById(R.id.tv);
        tv.setText("经营报表");
        View headView = View.inflate(this, R.layout.layout_report_head, null);
        mListView.addHeaderView(headView);


    }

    @Override
    protected void initData() {

        initReportData();

    }

    private List<ReportBean> datas = new ArrayList<>();

    private void initReportData() {
        for (int i = 0; i < 20; i++) {
            datas.add(new ReportBean("2017-02-" + i, "1单", "￥20" + i, "应收 20" + i));
        }
    }

    @Override
    protected void initListener() {
        mInclude.findViewById(R.id.rl_back).setOnClickListener(this);

        mQuery.setOnClickListener(this);
        mQueryStart.setOnClickListener(this);
        mQueryStop.setOnClickListener(this);

        mListView.setAdapter(new IAdapter(datas));
    }

    @Override
    protected void processClick(View v) {

        switch (v.getId()) {
            case R.id.btn_query:
                break;
            case R.id.tv_query_start:

                pvTime.show(mQueryStart);

                break;
            case R.id.tv_query_stop:
                pvTime2.show(mQueryStop);
                break;
        }

    }

    private class IAdapter extends BaseAdapter {

        private List<ReportBean> datas;

        public IAdapter(List<ReportBean> datas) {
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
                convertView = View.inflate(ReportActivity.this, R.layout.activity_report_item, null);

                vh.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
                vh.tv_order_num = (TextView) convertView.findViewById(R.id.tv_order_num);
                vh.tv_sales = (TextView) convertView.findViewById(R.id.tv_sales);
                vh.tv_revenues = (TextView) convertView.findViewById(R.id.tv_revenues);

                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            ReportBean mBean = datas.get(position);
            vh.tv_date.setText(mBean.getDate());
            vh.tv_order_num.setText(mBean.getOrderNum());
            vh.tv_sales.setText(mBean.getSales());
            vh.tv_revenues.setText(mBean.getRevenues());

            return convertView;
        }


        private final class ViewHolder {
            private TextView tv_date;
            private TextView tv_order_num;
            private TextView tv_sales;
            private TextView tv_revenues;
        }
    }

}
