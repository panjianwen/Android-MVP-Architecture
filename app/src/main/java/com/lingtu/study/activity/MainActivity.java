package com.lingtu.study.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.lingtu.study.MainHandler;
import com.lingtu.study.R;
import com.lingtu.study.entity.User;
import com.lingtu.study.entity.User2;
import com.lingtu.study.adapter.UserAdapter;
import com.lingtu.study.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private User mUser;
    private ActivityMainBinding mBinding;
    private User2 mUser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUser = new User("122", "ashfo");
        mBinding.setUser(mUser);

        mBinding.setMain(this);
        mBinding.setHandler(new MainHandler());
        mUser2 = new User2();
        mBinding.setUser2(mUser2);

        List<User2> user2s = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            User2 user2 = new User2();
            user2.firstName.set("first" + i);
            user2.lastName.set("last" + i);
            user2.age.set(i);
            user2s.add(user2);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        mBinding.recyclerView.setLayoutManager(layoutManager);
        mBinding.setAdapter(new UserAdapter(user2s));
    }

    public void onClick(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mUser2.lastName.set("lastName");
                mUser2.firstName.set("firstName");
                mUser2.age.set(20);
//                mBinding.setUser(mUser);
            }
        }, 2000);

    }
}
