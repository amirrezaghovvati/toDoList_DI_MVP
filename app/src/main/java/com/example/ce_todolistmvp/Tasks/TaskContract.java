package com.example.ce_todolistmvp.Tasks;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;
import com.example.ce_todolistmvp.Model.model.Tasks;

import java.util.List;

public interface TaskContract {
    interface TaskView extends BaseView{
        void getTaskList(List<Tasks> tasks);
        void deleteTasks(Tasks tasks);
        void onAdd();
        void clearAll();
        void clearAllConfirmed();
        void setClearAllIconVisility(boolean isShown);
        void onAdde(Tasks tasks);
        void updateTasks(Tasks tasks);
        void onBack();
        void getSize(int size);
    }
    interface TaskPresenter extends BasePresenter<TaskView>{
        void onAddClicked();
        void onClearAllClicked();
        void onClearAllConfirmed();
        void onDelteClickeD(Tasks tasks);
        void onAdded(Tasks tasks);
        void onUpdate(Tasks tasks);
        void onBackClicked();
    }
}
