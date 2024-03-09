package com.example.ce_todolistmvp.Starter.Splash;

import android.app.Activity;
import android.content.Context;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = SplashModule.class)
public interface SplashComponent {
    void injectFields(SplashActivity splashActivity);
    @Component.Factory
    interface Factory{
        SplashComponent build(@BindsInstance Context con, @BindsInstance Class<? extends Activity> activity);
    }
}
