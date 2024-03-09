package com.example.ce_todolistmvp.Starter.Splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {
    @Provides
    Intent provideIntent(Context context, Class<? extends Activity> activity){
        return new Intent(context,activity);

    }
    @Provides
    Handler provideHandler(){
        return new Handler();
    }

}
