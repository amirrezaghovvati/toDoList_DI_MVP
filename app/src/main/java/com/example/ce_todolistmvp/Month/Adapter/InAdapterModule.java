package com.example.ce_todolistmvp.Month.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class InAdapterModule {
    @Provides
    PopupMenu provideMenu(Context context, @Named("view") View view){
        return new PopupMenu(context,view);
    }
}
