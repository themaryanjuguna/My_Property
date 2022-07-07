package com.moringaschool.myproperty.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.myproperty.R;
import com.moringaschool.myproperty.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityLoginBinding logBind;
    FirebaseAuth myAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        logBind = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(logBind.getRoot());

        myAuth = FirebaseAuth.getInstance();

        logBind.addManager.setOnClickListener(this);
        logBind.login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == logBind.addManager){
            Intent intent = new Intent(LoginActivity.this, AddManagerActivity.class);
            startActivity(intent);
        }else if(v == logBind.login){
            login();
        }
    }

    private void login() {

        String email = logBind.userEmail.getEditText().getText().toString().trim();
        String password = logBind.password.getEditText().getText().toString().trim();

        myAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Intent intent = new Intent(LoginActivity.this, ManagerDashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}