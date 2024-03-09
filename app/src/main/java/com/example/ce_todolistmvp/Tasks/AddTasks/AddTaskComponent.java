package com.example.ce_todolistmvp.Tasks.AddTasks;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component( )
public interface AddTaskComponent {
    AddTaskDialog buildTaskDialoge();
    @Component.Factory
    interface Factory{
        AddTaskComponent build(@BindsInstance @Named("callBack")AddTaskDialog.AddTaskDialogCallBack callBack);
    }
}
