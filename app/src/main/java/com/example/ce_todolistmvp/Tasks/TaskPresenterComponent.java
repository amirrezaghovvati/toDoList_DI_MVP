package com.example.ce_todolistmvp.Tasks;

import android.content.Context;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Category;

import javax.inject.Named;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {TaskComponentModule.class})
public interface TaskPresenterComponent {
    void injectFields(FragmentTask task);
    @Component.Factory
    interface Factory{
        TaskPresenterComponent build(@BindsInstance @Named("cat")Category category,
                                     @BindsInstance Context context);
    }
}
