package com.tunity.assignment.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import com.tunity.assignment.data.database.room.repository.NewsListRoom;
import com.tunity.assignment.data.network.retrofit.repository.NewsListRetrofit;
import com.tunity.assignment.data.network.retrofit.response.ArticleVO;
import com.tunity.assignment.data.network.retrofit.util.NetworkConstants;
import com.tunity.assignment.data.repository.mapper.NewsMapper;

import org.reactivestreams.Subscription;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class NewsListViewModel extends ViewModel {

    private final MutableLiveData<List<ArticleEntity>> articlesListLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    @Inject
    public NewsListViewModel(NewsListRoom newsListRoom, NewsListRetrofit newsListRetrofit,NewsMapper newsMapper) {
        newsListRoom.getNewsListFromRoom()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ArticleEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ArticleEntity> entityList) {
                        articlesListLiveData.postValue(entityList);
                        Log.d("test---","list from room "+entityList.size());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        newsListRetrofit.getNewsListFromRetrofit(NetworkConstants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ArticleVO>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ArticleVO> voList) {
                        articlesListLiveData.postValue(newsMapper.mapVoListToEntityList(voList));
                        newsListRoom.addNewsListToRoom(newsMapper.mapVoListToEntityList(voList));
                        Log.d("test---","list from network "+voList.size());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<List<ArticleEntity>> getArticlesLiveData() {
        return articlesListLiveData;
    }

    public LiveData<String> observeErrorState() {
        return errorLiveData;
    }

}
