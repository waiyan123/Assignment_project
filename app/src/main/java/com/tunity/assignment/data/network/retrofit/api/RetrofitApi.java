package com.tunity.assignment.data.network.retrofit.api;

import com.tunity.assignment.BuildConfig;
import com.tunity.assignment.data.network.retrofit.response.NewsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {
    @GET(BuildConfig.POPULAR_NEWS_API_END_POINT)
    Observable<NewsResponse> getNewsResponse(@Query("apiKey")String apiKey);
}