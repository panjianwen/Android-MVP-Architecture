package com.lingtu.study.base;

import com.lingtu.study.net.ApiException;
import com.lingtu.study.net.ApiManager;
import com.lingtu.study.net.ResultException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by pan on 2019/5/5.
 */
public abstract class BaseObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ResultException) {
            onFailure(e.getMessage());
        } else {
            String error = ApiException.handleException(e).getMessage();
            onFailure(error);
        }
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T response);
    public abstract void onFailure(String message);
}
