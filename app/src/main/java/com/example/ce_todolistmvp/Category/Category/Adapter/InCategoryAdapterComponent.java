package com.example.ce_todolistmvp.Category.Category.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = InCategoryAdapterModule.class)
public interface InCategoryAdapterComponent {
    PopupMenu buildPopUpMenu();
    @Component.Factory
    interface Factory{
        InCategoryAdapterComponent build(@BindsInstance Context context, @BindsInstance View view);
    }
}
