package com.example.ce_todolistmvp.Category.Category.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

import dagger.Module;
import dagger.Provides;

@Module
public class InCategoryAdapterModule {
    @Provides
    PopupMenu providePopUpMenu(Context context, View view){
        return new PopupMenu(context,view);
    }
}
