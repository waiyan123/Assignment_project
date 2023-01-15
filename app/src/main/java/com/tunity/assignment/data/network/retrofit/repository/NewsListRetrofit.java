package com.tunity.assignment.data.network.retrofit.repository;

import com.tunity.assignment.data.network.retrofit.response.ArticleVO;
import com.tunity.assignment.data.network.retrofit.service.RetrofitService;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsListRetrofit {

    private final RetrofitService retrofitService;

    @Inject
    public NewsListRetrofit(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    public Observable<List<ArticleVO>> getNewsListFromRetrofit(String apiKey) {

        return retrofitService.getNewsResponse(apiKey).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result-> result.articlesList);
    }
}
