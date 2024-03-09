package com.example.ce_todolistmvp.Category.Category;

import android.content.Context;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Days;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = CategoryModule.class)
public interface CategoryComponent {
    void injectFields(FragmentCategory category);
    @Component.Factory
    interface Factory{
        CategoryComponent build(@BindsInstance @Named("days")Days days, @BindsInstance Context context);
    }
}
