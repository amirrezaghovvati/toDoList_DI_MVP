package com.example.ce_todolistmvp.Month.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

import javax.inject.Named;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Component;

@Component(modules = InAdapterModule.class)
public interface InMonthAdapterComponent {
    PopupMenu buildPopUp();
    @Component.Factory
    interface Factory{
        InMonthAdapterComponent build(@BindsInstance Context context, @BindsInstance @Named("view") View view);
    }
}
