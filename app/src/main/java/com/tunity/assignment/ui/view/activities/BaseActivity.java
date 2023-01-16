package com.tunity.assignment.ui.view.activities;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.tunity.assignment.ui.util.UiConstants;

public class BaseActivity extends AppCompatActivity {

    public void showSnackBar(String str, View rootLayout) {
        Snackbar snackbar = Snackbar.make(rootLayout,str,Snackbar.LENGTH_LONG);
        snackbar.setAction(UiConstants.got_it, view -> snackbar.dismiss());
        snackbar.show();
    }
}
