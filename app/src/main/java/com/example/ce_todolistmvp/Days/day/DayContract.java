package com.example.ce_todolistmvp.Days.day;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;

import java.util.List;

public interface DayContract {
    interface DayView extends BaseView {
        void getList(List<Days> days);
        void onAdd();
        void emptyStateVisibility(boolean isShown);

        void onItem(Days days);
        void onBack();
        void onClearAll();
        void onClearAllConfirm();
        void onDelete(Days days);
        void onUpdate(Days days);

    }
    interface DayPresenter extends BasePresenter<DayView>{
        void onAddDayClicked();
        void onClearAllClicked();
        void onClearAllConfirmed();
        void onBakcClicked();
        void onItemClicked(Days days);
        void onDeleteClicked(Days days);
        void onUpdateClicked(Days days);


    }
}
