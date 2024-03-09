package com.example.ce_todolistmvp.EditProfile;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;

public interface ContractProfile {
    interface EditProfileView extends BaseView {
        void getInfoes(String name,int res);
        void onLogOut();
        void onLogOUtConfirmed();
        void onSave();
        void onSaveConfirmed();
        void onBack();

    }
    interface EditProfilePresenter extends BasePresenter<EditProfileView> {
        void onLogOutClicked();
        void onLoutOutConfirmed();
        void onSaveClicked();
        void onSaveConfirmed(String naem,int res);
        void onBackClicked();
    }
}
