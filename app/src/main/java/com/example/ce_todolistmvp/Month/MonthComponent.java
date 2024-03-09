package com.example.ce_todolistmvp.Month;

import android.content.Context;
import android.view.View;

import com.example.ce_todolistmvp.Base.BaseSingleton;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = MonthModule.class)
public interface MonthComponent {
    void injectFields(FragmentMonth month);
    @Component.Factory
    interface Factory{
        MonthComponent build(@BindsInstance Context context, @BindsInstance @Named("view")View view);
    }
}
