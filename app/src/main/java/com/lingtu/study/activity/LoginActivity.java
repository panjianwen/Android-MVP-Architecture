package com.lingtu.study.activity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.lingtu.study.R;
import com.lingtu.study.base.BaseMvpActivity;
import com.lingtu.study.mvp.LoginContract;
import com.lingtu.study.mvp.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView mTextView;


    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
    }


    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void getDataResult(String data) {
        mTextView.setText(data);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        getPresenter().getData();
    }
}
