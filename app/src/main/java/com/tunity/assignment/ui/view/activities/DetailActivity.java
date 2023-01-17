package com.tunity.assignment.ui.view.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tunity.assignment.R;
import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import com.tunity.assignment.ui.util.UiConstants;

public class DetailActivity extends BaseActivity{

    Toolbar toolbar;

    public static Intent newIntent(Context context) {
        return new Intent(context,DetailActivity.class);
    }
    public static final String EXTRAS = "extras";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArticleEntity article = (ArticleEntity) getIntent().getSerializableExtra(EXTRAS);
        if(article!=null) {
            bindDetails(article);
        }
    }

    private void bindDetails(ArticleEntity article) {
        AppCompatTextView tvTitle = findViewById(R.id.tv_title_detail);
        AppCompatTextView tvAuthor = findViewById(R.id.tv_author_detail);
        AppCompatTextView tvSourceName = findViewById(R.id.tv_source_detail);
        AppCompatTextView tvUrl = findViewById(R.id.tv_url_detail);
        AppCompatTextView tvPublishAt = findViewById(R.id.tv_publish_at_detail);
        AppCompatTextView tvContent = findViewById(R.id.tv_content_detail);
        AppCompatImageView imgBanner = findViewById(R.id.img_detail_banner);

        if(article.urlToImage!=null) {
            Glide.with(this)
                    .load(Uri.parse(article.urlToImage))
                    .placeholder(R.drawable.img_placeholder)
                    .into(imgBanner);
        }
        if(article.title!=null) tvTitle.setText(article.title);
        if(article.author!=null) tvAuthor.setText(UiConstants.author + article.author);
        if(article.sourceLocal!=null) tvSourceName.setText(article.sourceLocal.name);
        if(article.url!=null) {
            tvUrl.setText(UiConstants.url);
            tvUrl.setTextColor(Color.BLUE);
            tvUrl.setOnClickListener(view -> {
                navigate(article.url);
            });
        }
        if(article.publishedAt!=null) tvPublishAt.setText(UiConstants.publish_at+article.publishedAt);
        if(article.content!=null) tvContent.setText(article.content);

        FloatingActionButton fabBack = findViewById(R.id.fab_back);
        fabBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    private void navigate(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
