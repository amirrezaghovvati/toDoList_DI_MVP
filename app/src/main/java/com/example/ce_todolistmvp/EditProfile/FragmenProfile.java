package com.example.ce_todolistmvp.EditProfile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import com.example.ce_todolistmvp.Model.shared.SignUpAuth;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.databinding.EditProfileBinding;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

public class FragmenProfile extends Fragment implements ContractProfile.EditProfileView{
    EditProfileBinding binding;
    @Inject ContractProfile.EditProfilePresenter presenter;
    @Inject
    SignUpAuth auth;
    @Inject
    AlertDialog.Builder builder;
    private int itemSelected=0;
    private EditProfileComponent component;

    @Override
    public void getInfoes(String name, int res) {
        binding.edtNameProfile.setText(name);
        binding.imgProfile.setImageResource(res);

        if (res==R.drawable.a_one){
            binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
            taskState= TaskState.SELECTED;
            itemSelected=1;
        }else if (res==R.drawable.a_two){
            binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
            taskState= TaskState.SELECTED;
            itemSelected=2;
        }else if (res==R.drawable.a_three){
            binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
            taskState= TaskState.SELECTED;
            itemSelected=3;
        }else if (res==R.drawable.g_one){
            binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
            taskState= TaskState.SELECTED;
            itemSelected=4;
        }else if (res== R.drawable.g_two){
            binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
            taskState= TaskState.SELECTED;
            itemSelected=5;
        }else if (res==R.drawable.g_three){
            binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
            taskState= TaskState.SELECTED;
            itemSelected=6;
        }
    }

    @Override
    public void onLogOut() {
        builder.setTitle("Clear All");
        builder.setMessage("Are You Sure To Loging Out?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            presenter.onLoutOutConfirmed();
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }

    @Override
    public void onLogOUtConfirmed() {
        //Navigation.findNavController(getView()).navigate(FragmenProfileDirections.actionFragmenProfileToNavigation());
        Navigation.findNavController(getView()).navigate(FragmenProfileDirections.actionFragmenProfileToNavigation());

    }

    @Override
    public void onSave() {

        builder.setTitle("Save");
        builder.setMessage("Are You Sure To Save?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            presenter.onSaveConfirmed(binding.edtNameProfile.getText().toString(),itemSelected);
        });

        builder.setNegativeButton("No",null);
        builder.show();
    }

    @Override
    public void onSaveConfirmed() {
   //
       Navigation.findNavController(getView()).navigate(FragmenProfileDirections.actionFragmenProfileToFragmentMonth());

    }

    @Override
    public void onBack() {
        getActivity().onBackPressed();
    }

    private enum TaskState{
        SELECTED,UNSELECTED
    }
    private TaskState taskState= TaskState.UNSELECTED;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=EditProfileBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        component=DaggerEditProfileComponent.builder().provideContext(getContext()).build();
        component.injectFields(this);

        binding.saveTxtProfile.setOnClickListener(v->{
            if (itemSelected>0 && taskState==TaskState.SELECTED&&binding.edtNameProfile.getText().length()>2){
                presenter.onSaveClicked();
            }else
                Snackbar.make(getView(),"Please Complete Your Profile!", BaseTransientBottomBar.LENGTH_SHORT).show();

        });
        binding.backProfile.setOnClickListener(v->{presenter.onBackClicked();});
        binding.logOutProfile.setOnClickListener(v->{
            presenter.onLogOutClicked();
        });


        binding.avatarBoyOne.setOnClickListener(v -> {
            switch (taskState){
                case SELECTED:
                    if (itemSelected==1){
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        taskState= TaskState.UNSELECTED.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        taskState=TaskState.SELECTED;
                        itemSelected=1;
                    }
                    break;
                case UNSELECTED:

                    binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    taskState=TaskState.SELECTED;
                    itemSelected=1;
                    break;
            }
        });
        binding.avatarBoyTwo.setOnClickListener(v -> {
            switch (taskState){
                case SELECTED:
                    if (itemSelected==2){
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        taskState= TaskState.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);

                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        taskState=TaskState.SELECTED;
                        itemSelected=2;
                    }
                    break;
                case UNSELECTED:
                    binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    taskState=TaskState.SELECTED;
                    itemSelected=2;
                    break;
            }



        });
        binding.avatarBoyThree.setOnClickListener(v->{
            switch (taskState){
                case SELECTED:
                    if (itemSelected==3){
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        taskState= TaskState.UNSELECTED;
                    }else {

                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        taskState= TaskState.SELECTED;
                        itemSelected=3;
                    }
                    break;


                case UNSELECTED:
                    binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    taskState= TaskState.SELECTED;
                    itemSelected=3;
                    break;
            }
        });
        binding.avatarGirlOne.setOnClickListener(v->{
            switch (taskState){
                case SELECTED:
                    if (itemSelected==4){
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        taskState= TaskState.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        taskState= TaskState.SELECTED;
                        itemSelected=4;
                    }
                    break;


                case UNSELECTED:
                    binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    taskState= TaskState.SELECTED;
                    itemSelected=4;
                    break;
            }
        });
        binding.avatarGirlTwo.setOnClickListener(v->{

            switch (taskState){
                case SELECTED:
                    if (itemSelected==5){
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        taskState=TaskState.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);

                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        taskState= TaskState.SELECTED;
                        itemSelected=5;
                    }
                    break;


                case UNSELECTED:
                    binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    taskState= TaskState.SELECTED;
                    itemSelected=5;
                    break;
            }
        });
        binding.avatarGirlThree.setOnClickListener(v->{
            switch (taskState){
                case SELECTED:
                    if (itemSelected==6){
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        taskState=TaskState.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        taskState=TaskState.SELECTED;
                        itemSelected=6;
                    }
                    break;


                case UNSELECTED:
                    binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    taskState=TaskState.SELECTED;
                    itemSelected=6;
                    break;
            }
        });

        presenter.onAttach(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
