package com.example.ce_todolistmvp.Starter.GetStart;

import dagger.Binds;
import dagger.Module;

@Module
public interface GetStartModule {
    @Binds
    GetStartContract.GetStartPresenter provideGetStartPresenter(GetStartPresenter getStartPresenter);
}
