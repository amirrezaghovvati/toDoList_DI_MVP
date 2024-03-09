package com.example.ce_todolistmvp.Days.day.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class InDayAdapterModule {
    @Provides
    PopupMenu providePopupmenu(@Named("cnt") Context context,@Named("v") View view){
        return new PopupMenu(context,view   );
    }
}
