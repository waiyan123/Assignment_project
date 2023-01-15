package com.tunity.assignment.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.tunity.assignment.R;
import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import com.tunity.assignment.data.network.retrofit.response.ArticleVO;
import com.tunity.assignment.ui.viewmodel.NewsListViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsListActivity extends AppCompatActivity {

    private NewsListViewModel newsListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsListViewModel = new ViewModelProvider(this).get(NewsListViewModel.class);
        newsListViewModel.getArticlesLiveData().observe(this, new Observer<List<ArticleEntity>>() {
            @Override
            public void onChanged(List<ArticleEntity> articleEntityList) {
//                Log.d("test---","list size "+ articleEntityList.size());
//                Log.d("test---","title "+ articleEntityList.get(0).title);
            }
        });
        newsListViewModel.observeErrorState().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
    }
}