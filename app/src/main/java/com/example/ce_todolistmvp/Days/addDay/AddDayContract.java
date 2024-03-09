package com.example.ce_todolistmvp.Days.addDay;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;
import com.example.ce_todolistmvp.Model.model.Days;

public interface AddDayContract {
    interface AddDayView extends BaseView{
        void onSaveClicked(Days days);
        void deleteIcVisibility(boolean isShown);
        void onBack();
        void onEditClicked(Days days);
        void dayDeleted();
        void onDelete(Days days);
    }

    interface AddDayPresenter extends BasePresenter<AddDayView>{
        void onSaveClicked(String year,String month,String day,int dayres);
        void onBackClicked();
        void onUpdateClicked(Days days,int res);
        void dayState(int state);
        void onDeleteClicked(Days days);
        void onDeleteConfirmed(Days days);

    }
}
