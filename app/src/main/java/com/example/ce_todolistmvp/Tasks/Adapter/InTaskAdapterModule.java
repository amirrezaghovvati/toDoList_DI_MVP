package com.example.ce_todolistmvp.Tasks.Adapter;

import com.example.ce_todolistmvp.Model.model.Tasks;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
@Module
public class InTaskAdapterModule {
    @Provides
    List<Tasks> provideTasks(){
        return  new ArrayList<>();
    }
}
