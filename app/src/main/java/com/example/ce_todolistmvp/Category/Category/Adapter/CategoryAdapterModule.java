package com.example.ce_todolistmvp.Category.Category.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Model.model.Category;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryAdapterModule {
    @Provides
    List<Category> provideList(@Named("list") List<Category> categoryList){
        return categoryList;
    }
    @Provides
    CategoryAdapter.CategoryEventListener provideEvent(@Named("event")CategoryAdapter.CategoryEventListener eventListener){
        return eventListener;
    }
    @Provides
    LinearLayoutManager provideLayout(Context context){
        return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }

}
