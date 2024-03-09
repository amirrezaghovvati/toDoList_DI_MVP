package com.example.ce_todolistmvp.Static;

import android.content.Context;

import com.anychart.AnyChart;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Pie;
import com.anychart.graphics.vector.SolidFill;
import com.example.ce_todolistmvp.Base.BaseSingleton;
import com.example.ce_todolistmvp.Model.local.AppDataBase;
import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.model.Month;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class StaticModule {
    @Provides
    Month provideMonth(@Named("month")Month month){
        return month;
    }
    @Provides
    Appdao provideAppDao(Context context){
        return AppDataBase.getAppDataBase(context).getDao();
    }
    @Provides
    StaticContract.StaticPresenter providePresenter(StaticPresenter presenter){
        return presenter;
    }
    @Provides
    List<DataEntry> provideData(){
        return new ArrayList<>();
    }
    @Provides
    Pie providePieChar(){
        return AnyChart.pie();
    }
    @BaseSingleton
    @Provides
    SolidFill firstColor(@Named("first")String color,@Named("firstO")int opacity){
      return new SolidFill(color,opacity);
    }
    @BaseSingleton
    @Named("two")
    @Provides
    SolidFill secondColor(@Named("second")String color,@Named("secondO")int opacity){
        return new SolidFill(color,opacity);
    }


}
