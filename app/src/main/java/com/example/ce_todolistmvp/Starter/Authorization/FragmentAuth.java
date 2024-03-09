package com.example.ce_todolistmvp.Starter.Authorization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ce_todolistmvp.Model.shared.SignUpAuth;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.databinding.YourInfoBinding;

import javax.inject.Inject;

public class FragmentAuth extends Fragment {
    private YourInfoBinding binding;
    @Inject
    SignUpAuth auth;
    private AuthComponent component;


    private int itemSelected=0;
    private enum AVATAR_STATE{
        SELECTED,UNSELECTED,RESELECT
    }
    private AVATAR_STATE avatar_state=AVATAR_STATE.UNSELECTED;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=YourInfoBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        component=DaggerAuthComponent.builder().setContext(getContext()).build();
        component.injectFields(this);
        //
        binding.avatarBoyOne.setOnClickListener(v -> {
            switch (avatar_state){
                case SELECTED:
                    if (itemSelected==1){
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        avatar_state=AVATAR_STATE.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        avatar_state=AVATAR_STATE.SELECTED;
                        itemSelected=1;
                    }
                    break;
                case UNSELECTED:

                    binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    avatar_state=AVATAR_STATE.SELECTED;
                    itemSelected=1;
                    break;
            }
        });
        binding.avatarBoyTwo.setOnClickListener(v -> {
            switch (avatar_state){
                case SELECTED:
                    if (itemSelected==2){
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        avatar_state=AVATAR_STATE.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);

                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        avatar_state=AVATAR_STATE.SELECTED;
                        itemSelected=2;
                    }
                    break;
                case UNSELECTED:
                    binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    avatar_state=AVATAR_STATE.SELECTED;
                    itemSelected=2;
                    break;
            }



        });
        binding.avatarBoyThree.setOnClickListener(v->{
            switch (avatar_state){
                case SELECTED:
                    if (itemSelected==3){
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        avatar_state=AVATAR_STATE.UNSELECTED;
                    }else {

                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        avatar_state=AVATAR_STATE.SELECTED;
                        itemSelected=3;
                    }
                    break;


                case UNSELECTED:
                    binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    avatar_state=AVATAR_STATE.SELECTED;
                    itemSelected=3;
                    break;
            }
        });
        binding.avatarGirlOne.setOnClickListener(v->{
            switch (avatar_state){
                case SELECTED:
                    if (itemSelected==4){
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        avatar_state=AVATAR_STATE.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        avatar_state=AVATAR_STATE.SELECTED;
                        itemSelected=4;
                    }
                    break;


                case UNSELECTED:
                    binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    avatar_state=AVATAR_STATE.SELECTED;
                    itemSelected=4;
                    break;
            }
        });
        binding.avatarGirlTwo.setOnClickListener(v->{

            switch (avatar_state){
                case SELECTED:
                    if (itemSelected==5){
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        avatar_state=AVATAR_STATE.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);

                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        avatar_state=AVATAR_STATE.SELECTED;
                        itemSelected=5;
                    }
                    break;


                case UNSELECTED:
                    binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    avatar_state=AVATAR_STATE.SELECTED;
                    itemSelected=5;
                    break;
            }
        });
        binding.avatarGirlThree.setOnClickListener(v->{
            switch (avatar_state){
                case SELECTED:
                    if (itemSelected==6){
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        avatar_state=AVATAR_STATE.UNSELECTED;
                    }else {
                        binding.avatarBoyThree.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarBoyOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlTwo.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlOne.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                        avatar_state=AVATAR_STATE.SELECTED;
                        itemSelected=6;
                    }
                    break;


                case UNSELECTED:
                    binding.avatarGirlThree.setBackgroundResource(R.drawable.sh_shape_circle_selection);
                    avatar_state=AVATAR_STATE.SELECTED;
                    itemSelected=6;
                    break;
            }
        });


        binding.startBtnYourName.setOnClickListener(v->{
            // FirebaseAnalytics.getInstance(getContext()).logEvent(FirebaseAnalytics.Event.LOGIN,null);
            if (avatar_state == AVATAR_STATE.SELECTED && binding.edtYourName.getText().length() > 3) {
                auth.saveName(binding.edtYourName.getText().toString());
                if (itemSelected==1){
                    auth.saveProfileRes(R.drawable.a_one);
                    //   FirebaseAnalytics.getInstance(getContext()).setUserProperty("sex","boys");
                }else if (itemSelected==2){
                    auth.saveProfileRes(R.drawable.a_two);
                    // FirebaseAnalytics.getInstance(getContext()).setUserProperty("sex","boys");
                }else if (itemSelected==3){
                    auth.saveProfileRes(R.drawable.a_three);
                    //FirebaseAnalytics.getInstance(getContext()).setUserProperty("sex","boys");
                }else if (itemSelected==4){
                    auth.saveProfileRes(R.drawable.g_one);
                    //FirebaseAnalytics.getInstance(getContext()).setUserProperty("sex","girls");
                }else if (itemSelected==5){
                    auth.saveProfileRes(R.drawable.g_two);
                    //FirebaseAnalytics.getInstance(getContext()).setUserProperty("sex","girls");
                }else if (itemSelected==6){
                    auth.saveProfileRes(R.drawable.g_three);
                    //FirebaseAnalytics.getInstance(getContext()).setUserProperty("sex","girls");
                }

                Navigation.findNavController(getView()).navigate(FragmentAuthDirections.actionGlobalFragmentMonth());
            }else if (avatar_state==AVATAR_STATE.UNSELECTED){
                Toast.makeText(getContext(), "Please select at least one avataar", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
