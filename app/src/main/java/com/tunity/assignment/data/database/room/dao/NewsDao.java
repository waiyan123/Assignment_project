package com.tunity.assignment.data.database.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticlesList(List<ArticleEntity>list);

    @Query("SELECT * FROM article_table")
    Observable<List<ArticleEntity>> getArticles();

}
