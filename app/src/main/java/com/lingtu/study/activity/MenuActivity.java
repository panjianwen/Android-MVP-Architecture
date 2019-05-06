package com.lingtu.study.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lingtu.study.R;
import com.lingtu.study.net.ApiService;
import com.lingtu.study.entity.User2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}
