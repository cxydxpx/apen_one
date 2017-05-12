package com.example.apen.onedemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/9.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "TAG";
    private SparseArray<View> mViews;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViews = new SparseArray<>();
        setContentView(layoutResId());
        ButterKnife.bind(this);
        init();

        initView();
        initData();
        initListener();
    }


    @Override
    protected void onResume() {
        super.onResume();
        showView();
    }

    protected abstract void showView();

    /**
     * 内容view
     *
     * @return
     */
    protected abstract int layoutResId();

    /**
     * 初始化
     */
    protected abstract void init();

    /**
     * 初始化view
     */
    protected abstract void initView();


    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化监听
     */
    protected abstract void initListener();


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            default:
                processClick(v);
                break;

        }


    }

    /**
     * 点击事件
     *
     * @param v
     */
    protected abstract void processClick(View v);

    public <E extends View> E findView(int id) {
        E view = (E) mViews.get(id);
        if (view == null) {
            view = (E) findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

}
