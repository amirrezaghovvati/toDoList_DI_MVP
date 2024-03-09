package com.example.ce_todolistmvp.Tasks;

import android.app.AlertDialog;
import android.content.Context;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.local.AppDataBase;
import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Category;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskComponentModule{
    @Provides
    TaskContract.TaskPresenter providePresenter(TasksPresenter tasksPresenter){
        return tasksPresenter;
    }
    @Provides
    @BaseSingleton
    Appdao provideAppDao(Context context){
        return AppDataBase.getAppDataBase(context).getDao();
    }
    @Provides
    Category provideCategory(@Named("cat")Category category){
        return category;
    }
    @Provides
    AlertDialog.Builder provideBuilder(Context context){
        return new AlertDialog.Builder(context);
    }
}
