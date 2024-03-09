package com.example.ce_todolistmvp.Starter.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ce_todolistmvp.MainActivity;
import com.example.ce_todolistmvp.R;


import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity {
    @Inject
    Intent intent;
    @Inject
    Handler handler;
    private SplashComponent component;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        component= DaggerSplashComponent.factory().build(this, MainActivity.class);
        component.injectFields(this);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        handler.postDelayed(() -> startActivity(intent),1000);


    }
}
