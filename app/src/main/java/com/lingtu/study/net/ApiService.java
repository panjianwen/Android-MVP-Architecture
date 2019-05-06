package com.lingtu.study.net;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by pan on 2019/4/30.
 */
public interface ApiService {

    @GET("api/v3/ranklist?num=10")
    Observable<ResponseBody> getRankList();
}
