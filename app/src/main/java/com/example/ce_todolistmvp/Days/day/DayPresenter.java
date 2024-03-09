package com.example.ce_todolistmvp.Days.day;

import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;

import java.util.List;

import javax.inject.Inject;

public class DayPresenter implements DayContract.DayPresenter{
    private DayContract.DayView dayView;
    private Appdao appdao;
    private Month month;
    @Inject
    public DayPresenter(Appdao appdao, Month month){this.appdao=appdao;
    this.month=month;}
    @Override
    public void onAttach(DayContract.DayView view) {
        this.dayView=view;
        List<Days> days=appdao.getAllDays(month.getMonthId());
        this.dayView.getList(days);
        if (days.size()>0){
            view.emptyStateVisibility(false);
        }else {
            view.emptyStateVisibility(true);
        }
    }

    @Override
    public void onDetach() {
        this.dayView=null;
    }

    @Override
    public void onAddDayClicked() {
        dayView.onAdd();
    }

    @Override
    public void onClearAllClicked() {

        dayView.onClearAll();
    }

    @Override
    public void onClearAllConfirmed() {
        appdao.clearAllDays(month.getMonthId());
        this.dayView.emptyStateVisibility(true);
        this.dayView.onClearAllConfirm();
    }

    @Override
    public void onBakcClicked() {
        dayView.onBack();
    }

    @Override
    public void onItemClicked(Days days) {
        dayView.onItem(days);
    }

    @Override
    public void onDeleteClicked(Days days) {
        appdao.deleteDays(days);
        if (appdao.getAllDays(month.getMonthId()).size()==0){
            dayView.emptyStateVisibility(true);
        }
        this.dayView.onDelete(days);
    }

    @Override
    public void onUpdateClicked(Days days) {
        appdao.updateDays(days);
        this.dayView.onUpdate(days);

    }
}
