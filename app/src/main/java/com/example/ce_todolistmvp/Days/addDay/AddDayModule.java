package com.example.ce_todolistmvp.Days.addDay;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.local.AppDataBase;
import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Month;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AddDayModule {
    @Provides
    Month provideMonth(@Named("month")Month month){return month;}
    @Provides
    @BaseSingleton
    Appdao provideAppDao(Context context){
        return AppDataBase.getAppDataBase(context).getDao();
    }
    @Provides
    AddDayContract.AddDayPresenter providePresenter(AddDayPresenter presenter){
        return presenter;
    }
    @Provides
    AlertDialog.Builder provideBuilder(Context context){
        return new AlertDialog.Builder(context);
    }
}
