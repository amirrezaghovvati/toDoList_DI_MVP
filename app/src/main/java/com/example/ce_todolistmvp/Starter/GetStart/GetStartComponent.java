package com.example.ce_todolistmvp.Starter.GetStart;

import dagger.Component;

@Component(modules = GetStartModule.class)
public interface GetStartComponent {
    void injectFields(FragmnetGetStart fragmnetGetStart);

}
