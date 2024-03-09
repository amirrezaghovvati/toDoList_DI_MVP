package com.example.ce_todolistmvp.Month.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Month;

import java.util.List;

import javax.inject.Named;


import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {MonthAdapterModule.class})
public interface MonthAdapterComponent {
    MonthAdapter create();
    LinearLayoutManager buildLayout();
    @Component.Factory
    interface Factory{
        MonthAdapterComponent build(@BindsInstance @Named("months")List<Month> months, @BindsInstance Context context, @BindsInstance @Named("listener")MonthAdapter.MonthEventListener eventListener);
    }
}
