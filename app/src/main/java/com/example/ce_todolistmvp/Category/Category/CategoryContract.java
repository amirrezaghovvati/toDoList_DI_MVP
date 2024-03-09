package com.example.ce_todolistmvp.Category.Category;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;
import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Days;

import java.util.List;

public interface CategoryContract {
    interface CatView extends BaseView{
        void setList(List<Category> categories);
        void setEmptyStateVisibiilt(boolean isShown);
        void onBack();
        void onAddClicked(Days days);
        void onClearAll();
        void onClearAllConfirmed();
        void onDelete(Category category);
        void onUpdate(Category category);
        void onItem(Category category);


    }
    interface CatPresenter extends BasePresenter<CatView>{
        void onBackClicked();
        void onDeleteClicked(Category category);
        void onUpdateClicked(Category category);
        void onItemClicked(Category category);
        void onClearAllClicked();
        void onClearAllConfirmed();
        void onAddClicked(Days days);
        int size(Category category);

    }
}
