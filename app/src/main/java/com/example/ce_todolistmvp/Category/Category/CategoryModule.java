package com.example.ce_todolistmvp.Category.Category;

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
public class CategoryModule {
    @Provides
    CategoryContract.CatPresenter providePresenter(CategoryPresenter presenter){
        return presenter;
    }
    @Provides
    Days provideDays(@Named("days") Days days){
        return days;
    }
    @Provides
    AlertDialog.Builder provideBuilder(Context context){
        return new AlertDialog.Builder(context);
    }
    @Provides
    @BaseSingleton
    Appdao provideDao(Context context){
       return AppDataBase.getAppDataBase(context).getDao();
    }
}
