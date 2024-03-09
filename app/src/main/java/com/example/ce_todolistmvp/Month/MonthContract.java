package com.example.ce_todolistmvp.Month;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;
import com.example.ce_todolistmvp.Model.model.Month;

import java.util.List;

public interface MonthContract {
    interface MonthView extends BaseView{
        void getMonthList(List<Month> months);
        void onStatic(Month month);
        void onMore(Month month);
        void onItem(Month month);
        void setEmptyStateVisibilit(boolean isShown);
        void onAdd();
        void onAdded(Month month);
        void onExit();
        void onClearAll();
        void onClearAllConfirmed();
        void onExitConfirmed();
        void onEditProfile();
        void onEdit(Month month);
        void onDeleteClicked(Month month);
        void onDeleteConfirmed(Month month);
        void onEdited(Month month);
        void setClearAllBtnVisibility(boolean isShow);
    }
    interface MonthPresenter extends BasePresenter<MonthView>{
        void onMoreClicked(Month month);
        void onItemClicked(Month month);
        void onStaticClicked(Month month);
        void onAddClicked();
        void onAdded(Month monthName);
        void onExitClicked();
        void onClearAllClicked();
        void onCleared();
        void onExited();
        void onEditProfileClicked();
        void onDeleteClicked(Month month);
        void onDeleteConfirmed(Month month);
        void onEditClicked(Month month);
        void onEdited(Month month);
    }
}
