package com.moringaschool.myproperty.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moringaschool.myproperty.R;
import com.moringaschool.myproperty.databinding.ActivityDefectPostBinding;
import com.moringaschool.myproperty.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBind.getRoot());

        setContentView(R.layout.activity_manager_dashboard);
    }
}