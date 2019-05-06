package com.lingtu.study.base;

import com.trello.rxlifecycle3.LifecycleTransformer;

/**
 * Created by pan on 2019/4/30.
 */
public interface BaseView {

    <T> LifecycleTransformer<T> bindToLifecycle();


    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();
}
