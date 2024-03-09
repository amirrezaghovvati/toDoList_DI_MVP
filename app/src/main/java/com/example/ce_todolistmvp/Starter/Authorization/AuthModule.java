package com.example.ce_todolistmvp.Starter.Authorization;

import android.content.Context;

import com.example.ce_todolistmvp.Model.shared.SignUpAuth;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {
    @Provides
    SignUpAuth provideAuth(Context context){
        return new SignUpAuth(context);
    }

}
