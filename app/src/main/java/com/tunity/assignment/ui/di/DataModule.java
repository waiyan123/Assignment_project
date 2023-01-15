package com.tunity.assignment.ui.di;

import com.tunity.assignment.data.database.room.MyRoomDatabase;
import com.tunity.assignment.data.database.room.dao.NewsDao;
import com.tunity.assignment.data.database.room.repository.NewsListRoom;
import com.tunity.assignment.data.network.retrofit.repository.NewsListRetrofit;
import com.tunity.assignment.data.network.retrofit.service.RetrofitService;
import com.tunity.assignment.data.repository.mapper.NewsMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@Module
@InstallIn(ViewModelComponent.class)
public class DataModule {

    @Provides
    @ViewModelScoped
    public NewsListRetrofit providesNewsListRetrofitInstance(
            RetrofitService retrofitService
    ) {
        return new NewsListRetrofit(retrofitService);
    }

    @Provides
    @ViewModelScoped
    public NewsListRoom providesNewsListRoomInstance(
            MyRoomDatabase myRoomDatabase
    ) {
        return new NewsListRoom(myRoomDatabase);
    }

    @Provides
    @ViewModelScoped
    public NewsMapper providesNewsMapperInstance() {
        return new NewsMapper();
    }
}
