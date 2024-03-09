package com.example.ce_todolistmvp.Month;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.local.AppDataBase;
import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.shared.SignUpAuth;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MonthModule {
    @Provides
    @BaseSingleton
    MonthContract.MonthPresenter provideMonthPresenter(MonthPresenter presenter){
        return presenter;
    }
    @Provides
    @BaseSingleton
    Appdao provideAppDao(Context context){
        return AppDataBase.getAppDataBase(context).getDao();
    }
    @Provides
    @BaseSingleton
    SignUpAuth provideAuth(Context context){
        return new SignUpAuth(context);
    }
    @Provides
    AlertDialog.Builder provideAlert(Context context){
        return new AlertDialog.Builder(context);
    }
    @Provides
    PopupMenu providePopUpMenu(Context context, @Named("view") View view){
        return new PopupMenu(context,view);
    }


}
