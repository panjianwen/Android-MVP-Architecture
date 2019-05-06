package com.lingtu.study.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.lingtu.study.BR;

/**
 * Created by pan on 2019/4/26.
 */
public   class User extends BaseObservable {
    private String userName;
    private String address;
    private boolean student;

    @Bindable
    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
        notifyPropertyChanged(BR.student);
    }

    public User(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }

    @Bindable
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }
}
