package com.lingtu.study.mvp;


import com.lingtu.study.base.BaseView;
import com.lingtu.study.base.IPresenter;

import io.reactivex.Observable;

/**
 * Created by pan on 2019/4/30.
 */
public class LoginContract {

    public interface View extends BaseView {

        void getDataResult(String data);

    }

    interface Presenter extends IPresenter<View> {

        void getData();
    }
}
