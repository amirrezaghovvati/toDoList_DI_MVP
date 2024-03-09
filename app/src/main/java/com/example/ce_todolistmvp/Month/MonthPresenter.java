package com.example.ce_todolistmvp.Month;

import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Month;

import java.util.List;

import javax.inject.Inject;

public class MonthPresenter implements MonthContract.MonthPresenter {
    private MonthContract.MonthView monthView;
    private Appdao appdao;
    @Inject
    public MonthPresenter(Appdao appdao){
        this.appdao=appdao;
    }
    @Override
    public void onAttach(MonthContract.MonthView view) {
        this.monthView=view;
        List<Month> months=appdao.getAllMonth();
        view.getMonthList(months);
        if (months.size()>0){
            view.setEmptyStateVisibilit(false);
            view.setClearAllBtnVisibility(true);
        }else{
            view.setEmptyStateVisibilit(true);
            view.setClearAllBtnVisibility(false);
        }
     }

    @Override
    public void onDetach() {
        this.monthView=null;
    }
    @Override
    public void onMoreClicked(Month month) {
        this.monthView.onMore(month);
    }

    @Override
    public void onItemClicked(Month month) {
        this.monthView.onItem(month);
    }

    @Override
    public void onStaticClicked(Month month) {
        this.monthView.onStatic(month);
    }

    @Override
    public void onAddClicked() {
        this.monthView.onAdd();
    }

    @Override
    public void onAdded(Month month) {
        long id=appdao.addMonth(month);
        if (id>0)
            month.setMonthId((int) id);
        this.monthView.onAdded(month);
        this.monthView.setEmptyStateVisibilit(false);
        this.monthView.setClearAllBtnVisibility(true);

    }

    @Override
    public void onExitClicked() {
        this.monthView.onExit();
    }



    @Override
    public void onClearAllClicked() {
        this.monthView.onClearAll();
    }

    @Override
    public void onCleared() {
        this.monthView.onClearAllConfirmed();
        appdao.clearAllMonth();
        this.monthView.setEmptyStateVisibilit(true);
        this.monthView.setClearAllBtnVisibility(false);

    }

    @Override
    public void onExited() {
        this.monthView.onExitConfirmed();
    }

    @Override
    public void onEditProfileClicked() {
        this.monthView.onEditProfile();
    }

    @Override
    public void onDeleteClicked(Month month) {
        this.monthView.onDeleteClicked(month);
    }

    @Override
    public void onDeleteConfirmed(Month month) {
        this.monthView.onDeleteConfirmed(month);
        appdao.deleteMonth(month);
        if (appdao.getAllMonth().size()==0){
            this.monthView.setEmptyStateVisibilit(true);
            this.monthView.setClearAllBtnVisibility(false);
        }
    }

    @Override
    public void onEditClicked(Month month) {
        this.monthView.onEdit(month);
    }

    @Override
    public void onEdited(Month month) {

        appdao.updateMonth(month);
        this.monthView.onEdited(month);
    }

}
