package com.tunity.assignment.data.network.retrofit.service;

import com.tunity.assignment.data.network.retrofit.response.NewsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("v2/everything?q=apple&from=2023-01-12&to=2023-01-12&sortBy=popularity")
    Observable<NewsResponse> getNewsResponse(@Query("apiKey")String apiKey);
}