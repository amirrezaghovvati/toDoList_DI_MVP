package com.example.ce_todolistmvp.EditProfile;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.shared.SignUpAuth;

import dagger.Module;
import dagger.Provides;

@Module
public class EditProfileModule {
    @Provides
    AlertDialog.Builder provideAlertDialoge(Context context){
        return new AlertDialog.Builder(context);
    }
    @Provides
    @BaseSingleton
    SignUpAuth provideAuth(Context context){
        return new SignUpAuth(context);
    }
    @Provides
    ContractProfile.EditProfilePresenter provideView(PresenterProfile presenter){
        return presenter;
    }
}
