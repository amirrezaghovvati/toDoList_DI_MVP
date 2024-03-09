package com.example.ce_todolistmvp.Month.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.model.Month;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MonthAdapterModule {
    @Provides
    LinearLayoutManager provideLayout(Context context){
        return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }
    @BaseSingleton
    @Provides
    List<Month> provideList(@Named("months")List<Month>months){return months;}
    @Provides
    MonthAdapter.MonthEventListener provideEvent(@Named("listener")MonthAdapter.MonthEventListener eventListener){return eventListener;}
}
