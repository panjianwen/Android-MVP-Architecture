package com.lingtu.study.entity;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * Created by pan on 2019/4/28.
 */
public class User2 {
    public   ObservableField<String> firstName = new ObservableField<>();
    public   ObservableField<String> lastName = new ObservableField<>();
    public   ObservableInt age = new ObservableInt();
    public   ObservableBoolean isStudent = new ObservableBoolean();
}
