package com.example.ce_todolistmvp.Static;

import android.content.Context;

import com.anychart.graphics.vector.SolidFill;
import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Month;

import javax.inject.Named;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {StaticModule.class})
public interface StaticComponent {
    void injectFields(FragmentStatic fragmentStatic);
   @Named("two") SolidFill crateSolidFillTwo();
    @Component.Factory
    interface Factory{
        StaticComponent build(@BindsInstance @Named("month") Month month, @BindsInstance Context context,
                              @BindsInstance @Named("first")String colorFirst,@BindsInstance @Named("firstO")int opacity,
                              @BindsInstance @Named("second")String secondColor,@BindsInstance @Named("secondO")int opacity2);
    }
}
