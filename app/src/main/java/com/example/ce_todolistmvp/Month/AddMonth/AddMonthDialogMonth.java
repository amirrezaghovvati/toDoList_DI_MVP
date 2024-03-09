package com.example.ce_todolistmvp.Month.AddMonth;

import com.example.ce_todolistmvp.Base.BaseSingleton;

import dagger.Component;
@BaseSingleton
@Component(modules = AddMonthDialogeModule.class)
public interface AddMonthDialogMonth {
    void injectFields(AddMonthDialoge dialoge);

}
