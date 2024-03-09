package com.example.ce_todolistmvp.Tasks;

import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Tasks;

import java.util.List;

import javax.inject.Inject;

public class TasksPresenter implements TaskContract.TaskPresenter{
    private Appdao appdao;
    private Category category;
    @Inject
    public TasksPresenter(Appdao appdao,Category category){
        this.appdao=appdao;
        this.category=category;
    }
    private TaskContract.TaskView view;
    @Override
    public void onAttach(TaskContract.TaskView view) {
        this.view=view;
        view.getTaskList(appdao.getAllTasks(category.getCategoryId()));
        view.getSize(appdao.getAllTasks(category.getCategoryId()).size());
        if (appdao.getAllTasks(category.getCategoryId()).size()==0){
            view.setClearAllIconVisility(true);
        }else{
            view.setClearAllIconVisility(false);
        }

    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onAddClicked() {
        this.view.onAdd();
    }

    @Override
    public void onClearAllClicked() {
        this.view.clearAll();
    }

    @Override
    public void onClearAllConfirmed() {
        appdao.clearAllTasks(category.getCategoryId());
        view.clearAllConfirmed();
        view.setClearAllIconVisility(true);
        view.getSize(appdao.getAllTasks(category.getCategoryId()).size());
    }

    @Override
    public void onDelteClickeD(Tasks tasks) {
        appdao.deleteTasks(tasks);
        view.deleteTasks(tasks);
        if (appdao.getAllTasks(category.getCategoryId()).size()==0)
            view.setClearAllIconVisility(true);

        view.getSize(appdao.getAllTasks(category.getCategoryId()).size());
    }

    @Override
    public void onAdded(Tasks tasks) {
        tasks.setCatId(category.getCategoryId());
        long id=appdao.addTasks(tasks);
        if (id>0){
            tasks.setTaskId((int) id);
        }
        view.setClearAllIconVisility(false);
        view.onAdde(tasks);
        view.getSize(appdao.getAllTasks(category.getCategoryId()).size());
    }

    @Override
    public void onUpdate(Tasks tasks) {
        appdao.updateTasks(tasks);
        view.updateTasks(tasks);
        view.getSize(appdao.getAllTasks(category.getCategoryId()).size());
    }

    @Override
    public void onBackClicked() {
        view.onBack();
    }
}
