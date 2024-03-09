package com.example.ce_todolistmvp.Tasks.Adapter;

import dagger.Component;

@Component(modules = {InTaskAdapterModule.class})
public interface InTaskAdapterComponent {
    void injectFields(TaskAdapter taskAdapter);
}
