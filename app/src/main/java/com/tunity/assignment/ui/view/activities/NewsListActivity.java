package com.tunity.assignment.ui.view.activities;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tunity.assignment.R;
import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import com.tunity.assignment.ui.view.adapters.NewsRecyclerAdapter;
import com.tunity.assignment.ui.view.listeners.AdapterPositionListener;
import com.tunity.assignment.ui.view.listeners.ListItemOnClickListener;
import com.tunity.assignment.ui.viewmodel.NewsListViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsListActivity extends BaseActivity implements ListItemOnClickListener,
        SwipeRefreshLayout.OnRefreshListener, AdapterPositionListener {
    private NewsListViewModel mViewModel;
    private RecyclerView rvList;
    private NewsRecyclerAdapter rvAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FloatingActionButton fabToTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        swipeRefreshLayout = findViewById(R.id.layout_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);



        rvList = findViewById(R.id.rv_news_list);
        rvAdapter = new NewsRecyclerAdapter(this,this);
        rvList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(rvAdapter);

        fabToTop = findViewById(R.id.fab_to_top);
        fabToTop.setOnClickListener(view -> {
            rvList.smoothScrollToPosition(0);
        });

        mViewModel = new ViewModelProvider(this).get(NewsListViewModel.class);
        mViewModel.getArticlesLiveData().observe(this, articleEntityList -> {
            rvAdapter.setNewData(articleEntityList);
            swipeRefreshLayout.setRefreshing(false);
        });
        mViewModel.observeErrorState().observe(this, errorStr -> {

        });
        mViewModel.fetchArticlesList();

    }

    @Override
    public void onClickItem(ArticleEntity article) {

    }

    @Override
    public void onRefresh() {
        mViewModel.fetchArticlesList();
    }

    @Override
    public void onPosition(Integer position) {
        Log.d("test---","position "+position);
        if(position>5) fabToTop.show();
        else fabToTop.hide();
    }

}