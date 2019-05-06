package com.lingtu.study.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Created by pan on 2019/5/5.
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
    }

    protected abstract P getPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
