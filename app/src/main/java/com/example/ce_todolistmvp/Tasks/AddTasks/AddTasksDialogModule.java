package com.example.ce_todolistmvp.Tasks.AddTasks;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Tasks;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AddTasksDialogModule {
    @Provides
    AlertDialog.Builder provideBuilder(@Named("cnt") Context context) {
        return new AlertDialog.Builder(context);
    }
    @BaseSingleton
    @Provides
    Tasks provideTasks(){
        return new Tasks();
    }
}
