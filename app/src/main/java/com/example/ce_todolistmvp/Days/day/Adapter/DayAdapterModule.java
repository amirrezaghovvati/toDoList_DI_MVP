package com.example.ce_todolistmvp.Days.day.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Model.model.Days;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class DayAdapterModule {
    @Provides
    List<Days> provideDays(@Named("days") List<Days> days){
        return days;
    }
    @Provides
    DayAdapter.DayAdapterEvents provideEvents(@Named("event")DayAdapter.DayAdapterEvents events){
        return events;
    }
    @Provides
    LinearLayoutManager provideLayout(Context context){
        return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }

}
