package com.example.ce_todolistmvp.Days.addDay;

import com.example.ce_todolistmvp.Base.BaseSingleton;

import dagger.Component;
@BaseSingleton
@Component(modules = PresenterModule.class)
public interface PresenterComponent {
    void injectFields(AddDayPresenter presenter);
}
