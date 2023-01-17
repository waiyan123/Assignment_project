package com.tunity.assignment.ui.di;

import android.content.Context;

import androidx.room.Room;

import com.tunity.assignment.BuildConfig;
import com.tunity.assignment.data.database.room.MyRoomDatabase;
import com.tunity.assignment.data.database.room.util.DatabaseConstants;
import com.tunity.assignment.data.network.retrofit.api.RetrofitApi;
import com.tunity.assignment.data.network.retrofit.util.NetworkConstants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public RetrofitApi providesRetrofitService(Retrofit retrofit) {
        return retrofit.create(RetrofitApi.class);
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        .connectTimeout(5000, TimeUnit.MILLISECONDS)
                        .readTimeout(5000,TimeUnit.MILLISECONDS)
                        .build())
                .build();
    }

    @Provides
    @Singleton
    public MyRoomDatabase providesRoomDatabaseInstance(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                        context,
                        MyRoomDatabase.class,
                        DatabaseConstants.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

}
