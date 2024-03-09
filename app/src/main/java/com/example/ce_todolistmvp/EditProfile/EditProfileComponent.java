package com.example.ce_todolistmvp.EditProfile;

import android.content.Context;

import com.example.ce_todolistmvp.Base.BaseSingleton;

import dagger.BindsInstance;
import dagger.Component;
@BaseSingleton
@Component(modules = {EditProfileModule.class})
public interface EditProfileComponent {
    void injectFields(FragmenProfile profile);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder provideContext(Context context);
        EditProfileComponent build();
    }
}
