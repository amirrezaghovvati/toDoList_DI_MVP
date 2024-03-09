package com.example.ce_todolistmvp.Category.AddCategory;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;
import com.example.ce_todolistmvp.Model.model.Category;

public interface AddCategoryContract {
    interface AddCatView extends BaseView{
        void onSaveClicked();
        void onDeleteIconVisility(boolean isShown);
        void onEdited();
        void itemDeleted();
        void onDelete(Category category);
    }
    interface AddCatPresenter extends BasePresenter<AddCatView>{
        void onSaved(String title,int res);
        void onDeleteClicked(Category category);
        void onDeleteConfirmed(Category category);
        void onEditSaved(Category category,int itemSelected);
        void fragmentState(int state);
    }
}
