package com.example.ce_todolistmvp.Tasks.AddTasks;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Tasks;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {AddTasksDialogModule.class})
public interface AddTaskDialogComponent {
    AlertDialog.Builder buildAlertBuilder();
    Tasks buildTasks();
    @Component.Factory
    interface Factory{
        AddTaskDialogComponent build(@BindsInstance @Named("cnt") Context context);
    }
}
