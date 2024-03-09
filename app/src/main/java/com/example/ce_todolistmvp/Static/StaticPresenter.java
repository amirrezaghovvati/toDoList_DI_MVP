package com.example.ce_todolistmvp.Static;

import android.util.Log;

import com.example.ce_todolistmvp.Base.App;
import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.Model.model.Tasks;

import java.util.List;

import javax.inject.Inject;

public class StaticPresenter implements StaticContract.StaticPresenter {
    private StaticContract.StaticView view;
    private Appdao appdao;
    private Month month;
    @Inject
    public StaticPresenter(Appdao appdao,Month month){
        this.appdao=appdao;
        this.month=month;
    }
    @Override
    public void onAttach(StaticContract.StaticView view) {
        this.view=view;
        int dones=0;
        int unDones=0;
        List<Days> daysList=appdao.getAllDays(month.getMonthId());

        for (int i = 0; i < daysList.size(); i++) {
            List<Category> categoryList = appdao.getAllCategory(daysList.get(i).getDayId());
            for (int j = 0; j < categoryList.size(); j++) {
                List<Tasks> tasksList = appdao.getAllTasks(categoryList.get(j).getCategoryId());
                int f = appdao.getAllCategory(categoryList.get(j).getCategoryId()).size();
                for (int k = 0; k < tasksList.size(); k++) {
                    if (tasksList.get(k).isDone()) {
                        dones++;
                    } else if (!tasksList.get(k).isDone()) {
                        unDones++;
                    }
                }
            }
        }
        view.setChartInfoes(dones,unDones);
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
    public void onAddClicked() {
        view.onAddItemClicked();
    }
}
