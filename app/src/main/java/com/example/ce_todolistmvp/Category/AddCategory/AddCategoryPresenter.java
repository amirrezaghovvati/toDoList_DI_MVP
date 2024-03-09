package com.example.ce_todolistmvp.Category.AddCategory;

import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.R;

import javax.inject.Inject;

public class AddCategoryPresenter implements AddCategoryContract.AddCatPresenter{
    private AddCategoryContract.AddCatView view;
    private AddCategoryComponent component;
    @Inject
    Category category;
    private Appdao appdao;
    private Days days;
    @Inject
    public AddCategoryPresenter(Appdao appdao,Days days){
        this.appdao=appdao;
        this.days=days;
    }
    @Override
    public void onAttach(AddCategoryContract.AddCatView view) {
            this.view=view;
            component=DaggerAddCategoryComponent.create();
            component.injectFields(this);

    }


    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onSaved(String title, int res) {
        if (res==1){
            category.setCategoryResId(R.drawable.t_personal);
        }else if (res==2){
            category.setCategoryResId(R.drawable.t_work);
        }else if (res==3){
            category.setCategoryResId(R.drawable.t_shopping);
        }else if (res==4){
            category.setCategoryResId(R.drawable.t_calendar);
        }else if (res==5){
            category.setCategoryResId(R.drawable.t_study);
        }else if (res==6){
            category.setCategoryResId(R.drawable.other);
        }
        category.setDayId(days.getDayId());
        category.setCategoryName(title);

        long id= appdao.addCategory(category);
        if (id>0){
            category.setCategoryId((int) id);
        }
        this.view.onSaveClicked();
    }

    @Override
    public void onDeleteClicked(Category category) {
        view.onDelete(category);
    }

    @Override
    public void onDeleteConfirmed(Category category) {
            appdao.deleteCategory(category);
            view.itemDeleted();
    }

    @Override
    public void onEditSaved(Category category,int res) {
        if (res==1){
            category.setCategoryResId(R.drawable.t_personal);
        }else if (res==2){
            category.setCategoryResId(R.drawable.t_work);
        }else if (res==3){
            category.setCategoryResId(R.drawable.t_shopping);
        }else if (res==4){
            category.setCategoryResId(R.drawable.t_calendar);
        }else if (res==5){
            category.setCategoryResId(R.drawable.t_study);
        }else if (res==6){
            category.setCategoryResId(R.drawable.other);
        }
        appdao.updateCategory(category);
        view.onEdited();
    }

    @Override
    public void fragmentState(int state) {
        if (state==0){
            view.onDeleteIconVisility(false);
        }else if (state==1){
            view.onDeleteIconVisility(true);
        }
    }
}
