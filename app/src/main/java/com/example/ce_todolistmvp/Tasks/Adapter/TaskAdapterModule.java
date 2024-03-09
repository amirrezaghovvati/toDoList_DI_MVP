package com.example.ce_todolistmvp.Tasks.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Tasks;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskAdapterModule {
    @Provides
    TaskAdapter.TaskEventListener eventListener(@Named("event")TaskAdapter.TaskEventListener eventListener ){
        return eventListener;
    }
    @BaseSingleton
    @Provides
    List<Tasks> tasks(@Named("tasks") List<Tasks> tasks){
        return tasks;
    }
    @Provides
    LinearLayoutManager provideLayout(Context context){
        return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }
}
