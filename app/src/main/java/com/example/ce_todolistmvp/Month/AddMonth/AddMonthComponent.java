package com.example.ce_todolistmvp.Month.AddMonth;

import com.example.ce_todolistmvp.Model.model.Month;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component
public interface AddMonthComponent {
    AddMonthDialoge buildAddMonthDialoge();
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder setCallBack(@Named("callBack")AddMonthDialoge.AddMonthCallBack callBack);
        @BindsInstance
        Builder setNamed(@Named("monthName") Month month);
        @BindsInstance
        Builder setStatus(@Named("status")int status);
        AddMonthComponent build();
    }
}
