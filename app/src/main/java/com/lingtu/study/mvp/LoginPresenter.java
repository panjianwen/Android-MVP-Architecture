package com.lingtu.study.mvp;

import com.lingtu.study.base.BaseObserver;
import com.lingtu.study.base.BasePresenter;
import com.lingtu.study.base.Transformer;

import java.io.IOException;

import okhttp3.ResponseBody;


/**
 *
 * @author pan
 * @date 2019/4/30
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void getData() {
        getApiService()
                .getRankList()
                .compose(Transformer.transformWithLoading(getView()))
                .subscribe(new BaseObserver<ResponseBody>() {
                    @Override
                    public void onSuccess(ResponseBody response) {
                        try {
                            getView().getDataResult(response.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(String message) {
                        getView().getDataResult(message);
                    }
                });
    }
}
