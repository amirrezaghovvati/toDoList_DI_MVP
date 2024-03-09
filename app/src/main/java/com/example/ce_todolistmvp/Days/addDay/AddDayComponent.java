package com.example.ce_todolistmvp.Days.addDay;

import android.content.Context;
import android.os.Build;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Month;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {AddDayModule.class})
public interface AddDayComponent {
    void injectFields(FragmentAddDay addDay);
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder setContext(Context context);
        @BindsInstance
        Builder setMonth(@Named("month")Month month);
        AddDayComponent buildComponent();
    }
}
