package com.example.ce_todolistmvp.Category.AddCategory;

import com.example.ce_todolistmvp.Model.model.Category;

import dagger.Module;
import dagger.Provides;

@Module
public class AddCategoryModule {
    @Provides
    Category provideCategory(){
        return new Category();
    }
}
