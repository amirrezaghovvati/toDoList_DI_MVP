package com.example.ce_todolistmvp.Days.addDay;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Days;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @BaseSingleton
    Days provideDays(){
        return new Days();
    }
}
