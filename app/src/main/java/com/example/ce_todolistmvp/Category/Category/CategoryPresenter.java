package com.example.ce_todolistmvp.Category.Category;

import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Days;

import java.util.List;

import javax.inject.Inject;

public class CategoryPresenter implements CategoryContract.CatPresenter{
    private CategoryContract.CatView view;
    private Days days;
    private Appdao appdao;

    @Inject
    public CategoryPresenter(Days days, Appdao appdao) {
        this.days = days;
        this.appdao = appdao;
    }

    @Override
    public void onAttach(CategoryContract.CatView view) {
        this.view=view;
        List<Category> categoryList=appdao.getAllCategory(days.getDayId());
        for (int i = 0; i < categoryList.size(); i++) {
          categoryList.get(i).setTaskCount(appdao.getAllTasks(categoryList.get(i).getCategoryId()).size());
        }
        view.setList(categoryList);
        if (categoryList.size()==0  ) {
            view.setEmptyStateVisibiilt(true);

        }else {
            view.setEmptyStateVisibiilt(false);
        }


    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onBackClicked() {
        this.view.onBack();
    }

    @Override
    public void onDeleteClicked(Category category) {
        appdao.deleteCategory(category);
        this.view.onDelete(category);
        if (appdao.getAllCategory(days.getDayId()).size()==0){
            view.setEmptyStateVisibiilt(true);
        }
    }

    @Override
    public void onUpdateClicked(Category category) {
        appdao.updateCategory(category);
        view.onUpdate(category);
    }

    @Override
    public void onItemClicked(Category category) {
        view.onItem(category);
    }

    @Override
    public void onClearAllClicked() {
        this.view.onClearAll();
    }

    @Override
    public void onClearAllConfirmed() {
        appdao.clearAllCategory(days.getDayId());
        this.view.setEmptyStateVisibiilt(true);
        this.view.onClearAllConfirmed();

    }

    @Override
    public void onAddClicked(Days days) {
        view.onAddClicked(days);
    }

    @Override
    public int size(Category category) {
        return appdao.getAllTasks(category.getCategoryId()).size();
    }
}
