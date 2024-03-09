package com.example.ce_todolistmvp.Category.AddCategory;

import android.content.Context;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Days;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {AddCategoryMainModule.class})
public interface AddCategoryMainComponent {
    void injectFields(FragmentAddCategory category);
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder setContext(Context context);
        @BindsInstance
        Builder setDays(@Named("days")Days days);
        AddCategoryMainComponent build();
    }
}
