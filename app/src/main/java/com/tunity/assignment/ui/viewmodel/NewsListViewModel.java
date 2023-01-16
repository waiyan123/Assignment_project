package com.tunity.assignment.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import com.tunity.assignment.data.database.LocalRepository;
import com.tunity.assignment.data.network.NetworkRepository;
import com.tunity.assignment.data.network.retrofit.response.ArticleVO;
import com.tunity.assignment.data.network.retrofit.util.NetworkConstants;
import com.tunity.assignment.data.repository.mapper.NewsMapper;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class NewsListViewModel extends ViewModel {

    private final MutableLiveData<List<ArticleEntity>> articlesListLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    private LocalRepository localRepository ;
    private NetworkRepository networkRepository;
    private NewsMapper newsMapper;
    @Inject
    public NewsListViewModel(LocalRepository localRepository, NetworkRepository networkRepository, NewsMapper newsMapper) {
        this.localRepository = localRepository;
        this.networkRepository = networkRepository;
        this.newsMapper = newsMapper;
    }

    public void fetchArticlesList() {
        localRepository.getNewsListFromRoom()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ArticleEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ArticleEntity> entityList) {
                        articlesListLiveData.postValue(entityList);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        networkRepository.getNewsListFromRetrofit(NetworkConstants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ArticleVO>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ArticleVO> voList) {
                        articlesListLiveData.postValue(newsMapper.mapVoListToEntityList(voList));
                        localRepository.addNewsListToRoom(newsMapper.mapVoListToEntityList(voList));
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
