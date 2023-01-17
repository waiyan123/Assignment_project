package com.tunity.assignment.ui.view.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.tunity.assignment.R;

public class DetailActivity extends BaseActivity{

    Toolbar toolbar;

    public static Intent newIntent(Context context) {
        return new Intent(context,DetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
