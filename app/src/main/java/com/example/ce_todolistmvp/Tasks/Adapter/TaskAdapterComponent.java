package com.example.ce_todolistmvp.Tasks.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Tasks;

import java.util.List;

import javax.inject.Named;


import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {TaskAdapterModule.class})
public interface TaskAdapterComponent {
    TaskAdapter buildAdapter();
    LinearLayoutManager buildLayout();
    @Component.Factory
    interface Factory{
        TaskAdapterComponent build(@BindsInstance @Named("tasks") List<Tasks> tasksList, @BindsInstance @Named("event")
                                   TaskAdapter.TaskEventListener eventListener,
                                   @BindsInstance Context context);
    }
}
