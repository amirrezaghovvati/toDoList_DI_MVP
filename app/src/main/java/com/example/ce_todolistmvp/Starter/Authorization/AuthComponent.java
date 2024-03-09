package com.example.ce_todolistmvp.Starter.Authorization;

import android.content.Context;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AuthModule.class)
public interface AuthComponent {
    void injectFields(FragmentAuth auth);
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder setContext(Context context);
        AuthComponent build();
    }
}
