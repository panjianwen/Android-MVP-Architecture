package com.lingtu.study.net;



import com.lingtu.study.app.App;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pan on 2019/5/5.
 */
public class ApiManager {
    private static final long DEFAULT_TIMEOUT = 20;

    private static ApiManager sApiManager;

    private Retrofit mRetrofit;

    private ApiManager() {
        //缓存
        int size = 1024 * 1024 * 100;
        File cacheFile = new File(App.getInstance().getCacheDir(), "OkHttpCache");
        Cache cache = new Cache(cacheFile, size);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .addNetworkInterceptor(new NetworkInterceptor())
//                .addNetworkInterceptor(loggingInterceptor)
//                .addInterceptor(loggingInterceptor)
//                .cache(cache)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(IPManager.BASE_URL)
                .client(client)
                //然后将下面的GsonConverterFactory.create()替换成我们自定义的ResponseConverterFactory.create()
//                .addConverterFactory(ResponseConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static ApiManager getInstance() {
        if (sApiManager == null) {
            synchronized (ApiManager.class) {
                if (sApiManager == null) {
                    sApiManager = new ApiManager();
                }
            }
        }
        return sApiManager;
    }

    public ApiService getApiService() {
        return mRetrofit.create(ApiService.class);
    }
}
