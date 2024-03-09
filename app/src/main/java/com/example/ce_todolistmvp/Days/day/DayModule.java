package com.example.ce_todolistmvp.Days.day;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.local.AppDataBase;
import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.Model.shared.SignUpAuth;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class DayModule {
    @Provides
    SignUpAuth provideAuth(Context context){
        return new SignUpAuth(context);
    }
    @Provides
    Month provideMonth(@Named("month") Month month){
        return month;
    }
    @Provides
    @BaseSingleton
    Appdao provideAppDao(Context context){
        return AppDataBase.getAppDataBase(context).getDao();
    }
    @Provides
     DayContract.DayPresenter providePresenter(DayPresenter dayPresenter){
        return dayPresenter;
    }
    @Provides
    AlertDialog.Builder provideBuilder(Context context){
        return new AlertDialog.Builder(context);
    }
}
