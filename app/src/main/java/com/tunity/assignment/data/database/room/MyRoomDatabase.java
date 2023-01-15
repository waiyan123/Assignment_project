package com.tunity.assignment.data.database.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.tunity.assignment.data.database.room.dao.NewsDao;
import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import com.tunity.assignment.data.database.room.typeconverters.SourceTypeConverter;

@Database(entities = ArticleEntity.class,version = 1,exportSchema = false)
@TypeConverters(SourceTypeConverter.class)
public abstract class MyRoomDatabase extends RoomDatabase {

    public abstract NewsDao newsDao();
}
