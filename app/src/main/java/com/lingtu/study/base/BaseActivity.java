package com.lingtu.study.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pan on 2019/4/30.
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
            mUnbinder = ButterKnife.bind(this);
        }
        initData(savedInstanceState);
    }

    protected abstract void initData(@Nullable Bundle savedInstanceState);

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
            this.mUnbinder = null;
        }
    }
}
