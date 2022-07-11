package com.moringaschool.myproperty.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.moringaschool.myproperty.R;

public class TenantLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_login);
        //AUTHENTICATE TENANT
        //START NEW INTENT IF SUCCESSFULL
        Intent intent = new Intent(TenantLoginActivity.this, TenantDashboardActivity.class);
        startActivity(intent);

    }
}