package com.example.ce_todolistmvp.Days.day.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {InDayAdapterModule.class})
public interface InDayAdapterComponent {
    PopupMenu buildPopUp();
    @Component.Factory
    interface Factoryz{
        InDayAdapterComponent build(@BindsInstance @Named("cnt") Context context,@Named("v") @BindsInstance View view);
    }
}
