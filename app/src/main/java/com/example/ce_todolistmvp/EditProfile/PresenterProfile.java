package com.example.ce_todolistmvp.EditProfile;


import com.example.ce_todolistmvp.Model.local.Appdao;
import com.example.ce_todolistmvp.Model.shared.SignUpAuth;
import com.example.ce_todolistmvp.R;

import javax.inject.Inject;


public class PresenterProfile implements ContractProfile.EditProfilePresenter {
    private ContractProfile.EditProfileView view;
    private SignUpAuth auth;

    @Inject
    public PresenterProfile(SignUpAuth auth){
        this.auth=auth;

    }
    @Override
    public void onAttach(ContractProfile.EditProfileView view) {
        this.view=view;
        this.view.getInfoes(auth.getUserName(),auth.getProfileRes());
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onLogOutClicked() {
        this.view.onLogOut();
    }

    @Override
    public void onLoutOutConfirmed() {
//        appDao.clearAllTaskFully();
//        appDao.clearAllDays();
//        appDao.clearAllTaskTitleFull();
        auth.clearAuthentication();
        this.view.onLogOUtConfirmed();
    }

    @Override
    public void onSaveClicked() {
        this.view.onSave();
    }

    @Override
    public void onSaveConfirmed(String name,int res) {
        if (res==1){
            res= R.drawable.a_one;
        }else if(res==2){
            res= R.drawable.a_two;
        }else if (res==3){
            res= R.drawable.a_three;
        }else if (res==4){
            res= R.drawable.g_one;
        }else if (res==5){
            res= R.drawable.g_two;
        }else if (res==6){
            res= R.drawable.g_three;
        }
        auth.updateUserProfile(name,res);

        this.view.onSaveConfirmed();
    }

    @Override
    public void onBackClicked() {
        view.onBack();
    }
}
