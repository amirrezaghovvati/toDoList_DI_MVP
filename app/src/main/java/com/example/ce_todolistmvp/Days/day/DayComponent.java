package com.example.ce_todolistmvp.Days.day;

import android.app.Application;
import android.content.Context;

import com.example.ce_todolistmvp.Base.App;
import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Month;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {DayModule.class})
public interface DayComponent  {
    void injectFields(FragmentDay fragmentDay);

    @Component.Factory
    interface Factory{
        DayComponent build(@BindsInstance Context context, @BindsInstance @Named("month")Month month);
    }
}
