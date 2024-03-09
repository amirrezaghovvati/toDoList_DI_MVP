package com.example.ce_todolistmvp.Days.day.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Model.model.Days;

import java.util.List;

import javax.inject.Named;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Component;

@Component(modules =DayAdapterModule.class )
public interface DayAdapterComponent {
    DayAdapter buildAdapter();
    LinearLayoutManager buildLinearLayoutManager();
    @Component.Factory
    interface Factory{
        DayAdapterComponent build(@BindsInstance Context context, @BindsInstance @Named("event") DayAdapter.DayAdapterEvents events,@Named("days") @BindsInstance List<Days> days);
    }
}
