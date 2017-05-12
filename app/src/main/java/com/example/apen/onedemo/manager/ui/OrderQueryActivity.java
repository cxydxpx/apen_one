package com.example.apen.onedemo.manager.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.example.apen.onedemo.BaseActivity;
import com.example.apen.onedemo.R;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;

import static com.example.apen.onedemo.utils.AppUtils.getTime;

/**
 * Created by Administrator on 2017/5/10.
 */

public class OrderQueryActivity extends BaseActivity {

    @BindView(R.id.tv_query_start)
    TextView mQueryStart;

    @BindView(R.id.tv_query_stop)
    TextView mQueryStop;

    @BindView(R.id.include)
    RelativeLayout mInclude;


    @Override
    protected int layoutResId() {
        return R.layout.activity_order_query;
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
        tv.setText("订单查询");
    }

    @Override
    protected void initData() {

    }

    private TimePickerView pvTime, pvTime2;

    @Override
    protected void initListener() {
        mInclude.findViewById(R.id.rl_back).setOnClickListener(this);
        mQueryStart.setOnClickListener(this);
        mQueryStop.setOnClickListener(this);
    }
    @Override
    protected void showView() {

    }
    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
            case R.id.tv_query_start:
                if (pvTime != null) {
                    pvTime.show(v);
                }
                break;
            case R.id.tv_query_stop:
                if (pvTime2 != null) {
                    pvTime2.show(v);
                }
                break;
            default:
                break;
        }

    }
}
