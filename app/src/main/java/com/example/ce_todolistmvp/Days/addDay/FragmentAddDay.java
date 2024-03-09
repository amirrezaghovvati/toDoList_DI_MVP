package com.example.ce_todolistmvp.Days.addDay;



import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.Starter.Authorization.FragmentAuth;
import com.example.ce_todolistmvp.databinding.AddDayBinding;

import javax.inject.Inject;

public class FragmentAddDay extends Fragment implements AddDayContract.AddDayView {
    private int itemSelected=0;
    private enum ADD_DAY_STATE{
        SELECTED,UNSELECTED
    }
    private ADD_DAY_STATE add_day_state= ADD_DAY_STATE.UNSELECTED;
    private Month month;
    private int state=0;
    private Days days;
    private AddDayBinding binding;
    @Inject
    AddDayContract.AddDayPresenter presenter;
    @Inject
    AlertDialog.Builder builder;
    private AddDayComponent addDayComponent;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        month=FragmentAddDayArgs.fromBundle(getArguments()).getMonth();
        state=FragmentAddDayArgs.fromBundle(getArguments()).getState();
        days=FragmentAddDayArgs.fromBundle(getArguments()).getDays();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=AddDayBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addDayComponent=DaggerAddDayComponent.builder().setContext(getContext()).setMonth(month).buildComponent();
        addDayComponent.injectFields(this);
        binding.addDateBack.setOnClickListener(v->{presenter.onBackClicked();});
        binding.saturdayIc.setOnClickListener(v->{
            switch (add_day_state){
                case SELECTED:
                    if (itemSelected==1){
                        binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_day_state=ADD_DAY_STATE.UNSELECTED;
                    }else {
                        binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);

                        add_day_state=ADD_DAY_STATE.SELECTED;
                        itemSelected=1;
                    }
                    break;
                case UNSELECTED:
                    binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    add_day_state=ADD_DAY_STATE.SELECTED;
                    itemSelected=1;
                    break;
            }
        });
        binding.sundayIc.setOnClickListener(v->{
            switch (add_day_state){
                case SELECTED:
                    if (itemSelected==2){
                        binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_day_state=ADD_DAY_STATE.UNSELECTED;
                    }else{
                        binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        add_day_state=ADD_DAY_STATE.SELECTED;
                        itemSelected=2;
                    }
                    break;
                case UNSELECTED:
                    binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    add_day_state=ADD_DAY_STATE.SELECTED;
                    itemSelected=2;
                    break;
            }
        });
        binding.mondayIc.setOnClickListener(v->{
            switch (add_day_state){
                case SELECTED:
                    if (itemSelected==3){
                        binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_day_state=ADD_DAY_STATE.UNSELECTED;
                    }else{
                        binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected=3;
                        add_day_state=ADD_DAY_STATE.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected=3;
                    add_day_state=ADD_DAY_STATE.SELECTED;
                    break;
            }
        });
        binding.tuesdayIc.setOnClickListener(v->{
            switch (add_day_state){
                case SELECTED:
                    if (itemSelected==4){
                        binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_day_state=ADD_DAY_STATE.UNSELECTED;
                    }else{
                        binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected=4;
                        add_day_state=ADD_DAY_STATE.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected=4;
                    add_day_state=ADD_DAY_STATE.SELECTED;
                    break;
            }
        });
        binding.wednesdayIc.setOnClickListener(v->{
            switch (add_day_state){
                case SELECTED:
                    if (itemSelected==5){
                        binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_day_state=ADD_DAY_STATE.UNSELECTED;
                    }else{
                        binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected=5;
                        add_day_state=ADD_DAY_STATE.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected=5;
                    add_day_state=ADD_DAY_STATE.SELECTED;
                    break;
            }
        });
        binding.thursdayIC.setOnClickListener(v->{
            switch (add_day_state){
                case SELECTED:
                    if (itemSelected==6){
                        binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_day_state=ADD_DAY_STATE.UNSELECTED;
                    }else{
                        binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected=6;
                        add_day_state=ADD_DAY_STATE.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected=6;
                    add_day_state=ADD_DAY_STATE.SELECTED;
                    break;
            }
        });
        binding.fridayIc.setOnClickListener(v->{
            switch (add_day_state){
                case SELECTED:
                    if (itemSelected==7){
                        binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_day_state=ADD_DAY_STATE.UNSELECTED;
                    }else{
                        binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected=7;
                        add_day_state=ADD_DAY_STATE.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected=7;
                    add_day_state=ADD_DAY_STATE.SELECTED;
                    break;
            }
        });
        if (state==0){

            binding.daySaveDayBtn.setOnClickListener(v->{
                if (add_day_state==ADD_DAY_STATE.SELECTED && binding.edtYear.getText().length()>3) {
                    presenter.onSaveClicked(binding.edtYear.getText().toString(),
                            binding.edtDateAddDay.getText().toString(),
                            binding.edtDayAddDay.getText().toString(), itemSelected);
                }
            });
        }else if (state==1){

            binding.edtYear.setText(days.getYear());
            binding.edtDateAddDay.setText(days.getMonth());
            binding.edtDayAddDay.setText(days.getDayWeek());
            if (days.getResId()==R.drawable.w_saturday){
              binding.saturdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
              add_day_state=ADD_DAY_STATE.SELECTED;
              itemSelected=1;
            }else if (days.getResId()==R.drawable.w_sunday){
                binding.sundayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_day_state=ADD_DAY_STATE.SELECTED;
                itemSelected=2;
            }else if (days.getResId()==R.drawable.w_monday){
                binding.mondayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_day_state=ADD_DAY_STATE.SELECTED;
                itemSelected=3;
            }else if (days.getResId()==R.drawable.w_tuesday){
                binding.tuesdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_day_state=ADD_DAY_STATE.SELECTED;
                itemSelected=4;
            }else if (days.getResId()==R.drawable.w_wednesday){
                binding.wednesdayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_day_state=ADD_DAY_STATE.SELECTED;
                itemSelected=5;
            }else if (days.getResId()==R.drawable.w_thursday){
                binding.thursdayIC.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_day_state=ADD_DAY_STATE.SELECTED;
                itemSelected=6;
            }else if (days.getResId()==R.drawable.w_friday){
                binding.fridayIc.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_day_state=ADD_DAY_STATE.SELECTED;
                itemSelected=7;
            }
            binding.daySaveDayBtn.setOnClickListener(v->{
                if (add_day_state==ADD_DAY_STATE.SELECTED && binding.edtYear.getText().length()>3){
                    days.setDayWeek(binding.edtDayAddDay.getText().toString());
                    days.setYear(binding.edtYear.getText().toString());
                    days.setMonth(binding.edtDateAddDay.getText().toString());


                    presenter.onUpdateClicked(days,itemSelected);
                }
            });
            }

        binding.deleteItem.setOnClickListener(v->{
            if (state==1) {
                presenter.onDeleteClicked(days);
            }
        });



        presenter.onAttach(this);
        if (state==1){
            presenter.dayState(1);
        }else
            presenter.dayState(0);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void onSaveClicked(Days days) {
        Navigation.findNavController(getView()).navigate(FragmentAddDayDirections.actionFragmentAddDayToFragmentDay(month,days));
    }

    @Override
    public void deleteIcVisibility(boolean isShown) {
     binding.deleteItem.setVisibility(isShown?View.VISIBLE:View.GONE);


    }

    @Override
    public void onBack() {
        getActivity().onBackPressed();
    }

    @Override
    public void onEditClicked(Days days) {
        Navigation.findNavController(getView()).navigate(FragmentAddDayDirections.actionFragmentAddDayToFragmentDay(month,days));
    }

    @Override
    public void dayDeleted() {
        Navigation.findNavController(getView()).navigate(FragmentAddDayDirections.actionFragmentAddDayToFragmentDay(month,days));
    }

    @Override
    public void onDelete(Days days) {
        builder.setTitle("Clear All");
        builder.setMessage("Are You Sure To Clear All?");
        builder.setPositiveButton("Yes",(o,p)->{
            presenter.onDeleteConfirmed(days);
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }
}
