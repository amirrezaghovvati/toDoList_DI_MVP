package com.example.ce_todolistmvp.Month.AddMonth;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Month;

import dagger.Module;
import dagger.Provides;

@Module
public class AddMonthDialogeModule {
    @Provides
    @BaseSingleton
    Month provideMonth(){
        return new Month();
    }
}
