package com.tunity.assignment.data.database;

import com.tunity.assignment.data.database.room.MyRoomDatabase;
import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LocalRepository {

    private final MyRoomDatabase myRoomDatabase;

    @Inject
    public LocalRepository(MyRoomDatabase myRoomDatabase) {
        this.myRoomDatabase = myRoomDatabase;
    }

    public Observable<List<ArticleEntity>> getNewsListFromRoom() {
        return myRoomDatabase.newsDao().getArticles();
    }

    public void addNewsListToRoom(List<ArticleEntity> articleEntityList) {
        myRoomDatabase.newsDao().insertArticlesList(articleEntityList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
