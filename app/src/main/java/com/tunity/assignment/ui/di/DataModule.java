package com.tunity.assignment.ui.di;

import com.tunity.assignment.data.database.room.MyRoomDatabase;
import com.tunity.assignment.data.database.LocalRepository;
import com.tunity.assignment.data.network.NetworkRepository;
import com.tunity.assignment.data.network.retrofit.api.RetrofitApi;
import com.tunity.assignment.data.NewsMapper;

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
    public NetworkRepository providesNewsListRetrofitInstance(
            RetrofitApi retrofitApi
    ) {
        return new NetworkRepository(retrofitApi);
    }

    @Provides
    @ViewModelScoped
    public LocalRepository providesNewsListRoomInstance(
            MyRoomDatabase myRoomDatabase
    ) {
        return new LocalRepository(myRoomDatabase);
    }

    @Provides
    @ViewModelScoped
    public NewsMapper providesNewsMapperInstance() {
        return new NewsMapper();
    }
}
