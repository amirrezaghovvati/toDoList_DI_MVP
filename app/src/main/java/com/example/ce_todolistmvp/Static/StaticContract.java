package com.example.ce_todolistmvp.Static;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;

import java.util.List;

public interface StaticContract {
    interface StaticView extends BaseView{
        void setChartInfoes(int dones,int unDones);
        void onBack();
        void onAddItemClicked();
    }
    interface StaticPresenter extends BasePresenter<StaticView>{
        void onBackClicked();
        void onAddClicked();
    }
}
