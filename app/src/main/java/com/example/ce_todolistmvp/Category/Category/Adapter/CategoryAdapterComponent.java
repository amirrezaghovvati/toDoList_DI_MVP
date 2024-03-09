package com.example.ce_todolistmvp.Category.Category.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Category.Category.FragmentCategory;
import com.example.ce_todolistmvp.Model.model.Category;

import java.util.List;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {CategoryAdapterModule.class})
public interface CategoryAdapterComponent {
    LinearLayoutManager buildLayout();
    CategoryAdapter buildAdapter();

    @Component.Factory
    interface Factory{
        CategoryAdapterComponent build(@BindsInstance @Named("event")CategoryAdapter.CategoryEventListener eventListener,
                                       @BindsInstance @Named("list") List<Category> categoryList,
                                       @BindsInstance Context context);
    }
}
