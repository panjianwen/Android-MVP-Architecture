package com.lingtu.study.base;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pan on 2019/5/5.
 */
public class Transformer {
    /**
     * 无参数  仅做切换线程
     *
     * @param <T> 泛型
     * @return 返回Observable
     */
    public static <T> ObservableTransformer<T, T> transform() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 界面请求，不需要加载和隐藏loading时调用 使用RxLifeCycle
     * 传入view接口，Activity，Fragment等实现了view接口，Activity，Fragment继承于{@link com.trello.rxlifecycle3.components.support.RxAppCompatActivity}
     * 也就实现了bindToLifecycle方法
     *
     * @param view View
     * @param <T>  泛型
     * @return
     */
    public static <T> ObservableTransformer<T, T> transform(final BaseView view) {
        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).compose(view.<T>bindToLifecycle());
            }
        };
    }

    /**
     * 界面请求，需要加载和隐藏loading时调用,使用RxLifeCycle
     * 传入view接口，Activity，Fragment等实现了view接口，Activity，Fragment继承于{@link com.trello.rxlifecycle3.components.support.RxAppCompatActivity}
     * 也就实现了bindToLifecycle方法
     *
     * @param view View
     * @param <T>  泛型
     * @return
     */
    public static <T> ObservableTransformer<T, T> transformWithLoading(final BaseView view) {
        //隐藏进度条
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                view.showLoading();
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .doFinally(new Action() {
                            @Override
                            public void run() throws Exception {
                                view.hideLoading();
                            }
                        })
                        .compose(view.<T>bindToLifecycle());
            }
        };

    }
}
