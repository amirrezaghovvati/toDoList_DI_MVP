package com.example.ce_todolistmvp.Days.addDay;

import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.R;

import javax.inject.Inject;

public class AddDayPresenter implements AddDayContract.AddDayPresenter{
    private AddDayContract.AddDayView view;
    private PresenterComponent component;
    private Appdao appdao;
    private Month month;
    @Inject
    Days days;
    @Inject
    public AddDayPresenter(Appdao appdao,Month month){
        this.appdao=appdao;
        this.month=month;
    }
    @Override
    public void onAttach(AddDayContract.AddDayView view) {
        this.view=view;
        component=DaggerPresenterComponent.create();
        component.injectFields(this);




    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onSaveClicked(String year, String month, String day, int dayres) {
        if (dayres== 1){
            days.setDayName("Saturday");
            days.setResId(R.drawable.w_saturday);
        }else if (dayres==2){
            days.setDayName("Sunday");
            days.setResId(R.drawable.w_sunday);
        }else if (dayres==3){
            days.setDayName("Monday");
            days.setResId(R.drawable.w_monday);
        }else if (dayres==4){
            days.setDayName("Tuesday");
            days.setResId(R.drawable.w_tuesday);
        }else if (dayres==5){
            days.setDayName("Wednesday");
            days.setResId(R.drawable.w_wednesday);
        }else if (dayres==6){
            days.setDayName("Thursday");
            days.setResId(R.drawable.w_thursday);
        }else if (dayres==7){
            days.setDayName("Friday");
            days.setResId(R.drawable.w_friday);
        }

        days.setYear(year);
        days.setMonth(month);
        days.setMonthId(this.month.getMonthId());
        days.setDayWeek(day);
        long id=appdao.addDays(days);
        if (id>0){
            days.setDayId((int) id);
        }
        this.view.onSaveClicked(days);
    }

    @Override
    public void onBackClicked() {
        this.view.onBack();
    }

    @Override
    public void onUpdateClicked(Days days,int itemSelected) {

        if (itemSelected==1){
            days.setResId(R.drawable.w_saturday);
            days.setDayName("Saturday");
        }else if (itemSelected==2){
            days.setResId(R.drawable.w_sunday);
            days.setDayName("Sunday");
        }else if (itemSelected==3){
            days.setResId(R.drawable.w_monday);
            days.setDayName("Monday");
        }else if (itemSelected==4){
            days.setResId(R.drawable.w_tuesday);
            days.setDayName("Tuesday");
        }else if (itemSelected==5){
            days.setResId(R.drawable.w_wednesday);
            days.setDayName("Wednesday");
        }else if (itemSelected==6){
            days.setResId(R.drawable.w_thursday);
            days.setDayName("Thursday");
        }else if (itemSelected==7){
            days.setResId(R.drawable.w_friday);
            days.setDayName("Friday");
        }

        appdao.updateDays(days);
        view.onEditClicked(days);
    }

    @Override
    public void dayState(int state) {
        if (state==0){
             this.view.deleteIcVisibility(false);
        }else if (state==1){
            this.view.deleteIcVisibility(true);
        }
    }

    @Override
    public void onDeleteClicked(Days days) {
     view.onDelete(days);
    }

    @Override
    public void onDeleteConfirmed(Days days) {
        appdao.deleteDays(days);
        view.dayDeleted();
    }
}
