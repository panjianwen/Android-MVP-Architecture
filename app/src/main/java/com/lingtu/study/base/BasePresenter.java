package com.lingtu.study.base;

import com.lingtu.study.net.ApiManager;
import com.lingtu.study.net.ApiService;

import java.lang.ref.WeakReference;

/**
 * Created by pan on 2019/4/30.
 */
public class BasePresenter<V extends BaseView> implements IPresenter<V>{

    private WeakReference<V> mView;

    protected ApiService getApiService() {
        return ApiManager.getInstance().getApiService();
    }

    public BasePresenter(V view) {
        attachView(view);
    }

    @Override
    public void attachView(V view) {
        this.mView = new WeakReference<V>(view);
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }

    protected V getView() {
        return mView.get();
    }
}
