package com.tunity.assignment.data.network;

import com.tunity.assignment.data.network.retrofit.api.RetrofitApi;
import com.tunity.assignment.data.network.retrofit.response.ArticleVO;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NetworkRepository {

    private final RetrofitApi retrofitApi;

    @Inject
    public NetworkRepository(RetrofitApi retrofitApi) {
        this.retrofitApi = retrofitApi;
    }

    public Observable<List<ArticleVO>> getNewsListFromRetrofit(String apiKey) {

        return retrofitApi.getNewsResponse(apiKey).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result-> result.articlesList);
    }
}
