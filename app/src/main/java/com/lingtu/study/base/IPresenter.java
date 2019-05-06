package com.lingtu.study.base;

/**
 * Created by pan on 2019/5/5.
 */
public interface IPresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
