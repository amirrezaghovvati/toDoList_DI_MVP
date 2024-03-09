package com.example.ce_todolistmvp.Category.AddCategory;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.local.AppDataBase;
import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Days;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AddCategoryMainModule {
    @Provides
    AddCategoryContract.AddCatPresenter providePresenter(AddCategoryPresenter presenter ){
        return presenter;
    }
    @Provides
    @BaseSingleton
    Appdao provideAppDao(Context context){
        return AppDataBase.getAppDataBase(context).getDao();
    }
    @Provides
    Days provideDays(@Named("days") Days days){
        return days;
    }
    @Provides
    AlertDialog.Builder provideAlertDialog(Context context){
        return new AlertDialog.Builder(context);
    }

}
