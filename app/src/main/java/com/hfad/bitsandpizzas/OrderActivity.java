package com.hfad.bitsandpizzas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class OrderActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //需要使用支持库中的工具条
        ActionBar actionBar = getSupportActionBar();
        //启用向上按钮，尽管我们要用一个工具条作为应用条
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }
}