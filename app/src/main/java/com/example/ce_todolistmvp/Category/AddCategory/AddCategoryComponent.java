package com.example.ce_todolistmvp.Category.AddCategory;

import dagger.Component;

@Component(modules = AddCategoryModule.class)
public interface AddCategoryComponent {
    void injectFields(AddCategoryPresenter addCategoryPresenter);
}
