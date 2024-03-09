package com.example.ce_todolistmvp.Category.AddCategory;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import com.example.ce_todolistmvp.Days.addDay.FragmentAddDay;
import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.databinding.AddTaksBinding;

import javax.inject.Inject;

public class FragmentAddCategory extends Fragment implements AddCategoryContract.AddCatView{
    private int itemSelected=0;
    private enum ADD_CATEGORY{
        SELECTED,UNSELECTED
    }
    private ADD_CATEGORY add_category=ADD_CATEGORY.UNSELECTED;

   int state=0;
    AddTaksBinding binding;
    @Inject
    AddCategoryContract.AddCatPresenter presenter;
    @Inject
    AlertDialog.Builder builder;
    private AddCategoryMainComponent component;
    private Days days;
    private Category category;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        days=FragmentAddCategoryArgs.fromBundle(getArguments()).getDays();
        category=FragmentAddCategoryArgs.fromBundle(getArguments()).getCategory();
        state=FragmentAddCategoryArgs.fromBundle(getArguments()).getState();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=AddTaksBinding.inflate(inflater,container,false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        component=DaggerAddCategoryMainComponent.builder().setContext(getContext()).setDays(days).build();
        component.injectFields(this);
        binding.icPersonal.setOnClickListener(v -> {
            switch (add_category) {
                case SELECTED:
                    if (itemSelected == 1) {
                        binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_category = ADD_CATEGORY.UNSELECTED;
                    } else {
                        binding.icWork.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icShopping.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icStudy.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icOther.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected = 1;
                        add_category = ADD_CATEGORY.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected = 1;
                    add_category = ADD_CATEGORY.SELECTED;
                    break;
            }
        });
        binding.icWork.setOnClickListener(v -> {
            switch (add_category) {
                case SELECTED:
                    if (itemSelected == 2) {
                        binding.icWork.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_category = ADD_CATEGORY.UNSELECTED;
                    } else {
                        binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icShopping.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icStudy.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icOther.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icWork.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected = 2;
                        add_category = ADD_CATEGORY.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.icWork.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected = 2;
                    add_category = ADD_CATEGORY.SELECTED;
                    break;
            }
        });
        binding.icShopping.setOnClickListener(v -> {
            switch (add_category) {
                case SELECTED:
                    if (itemSelected == 3) {
                        binding.icShopping.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_category = ADD_CATEGORY.UNSELECTED;
                    } else {
                        binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icWork.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icStudy.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icOther.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icShopping.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected = 3;
                        add_category = ADD_CATEGORY.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.icShopping.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected = 3;
                    add_category = ADD_CATEGORY.SELECTED;
                    break;
            }
        });
        binding.icCalendar.setOnClickListener(v -> {
            switch (add_category) {
                case SELECTED:
                    if (itemSelected == 4) {
                        binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_category = ADD_CATEGORY.UNSELECTED;
                    } else {
                        binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icShopping.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icWork.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icStudy.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icOther.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected = 4;
                        add_category = ADD_CATEGORY.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected = 4;
                    add_category = ADD_CATEGORY.SELECTED;
                    break;
            }
        });
        binding.icStudy.setOnClickListener(v -> {
            switch (add_category) {
                case SELECTED:
                    if (itemSelected == 5) {
                        binding.icStudy.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_category = ADD_CATEGORY.UNSELECTED;
                    } else {
                        binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icShopping.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icWork.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icOther.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icStudy.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected = 5;
                        add_category = ADD_CATEGORY.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.icStudy.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected = 5;
                    add_category = ADD_CATEGORY.SELECTED;
                    break;
            }
        });
        binding.icOther.setOnClickListener(v -> {
            switch (add_category) {
                case SELECTED:
                    if (itemSelected == 6) {
                        binding.icOther.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        add_category = ADD_CATEGORY.UNSELECTED;
                    } else {
                        binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icShopping.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icStudy.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icWork.setBackgroundResource(R.drawable.sh_shape_default_avataar);
                        binding.icOther.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                        itemSelected = 6;
                        add_category = ADD_CATEGORY.SELECTED;
                    }
                    break;
                case UNSELECTED:
                    binding.icOther.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                    itemSelected = 6;
                    add_category = ADD_CATEGORY.SELECTED;
                    break;
            }
        });
        if (state==1){
            binding.edtTaskCategoryName.setText(category.getCategoryName());
            if (category.getCategoryResId()==R.drawable.t_personal){
                binding.icPersonal.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_category=ADD_CATEGORY.SELECTED;
                itemSelected=1;
            }else if (category.getCategoryResId()==R.drawable.t_work){
                binding.icWork.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_category=ADD_CATEGORY.SELECTED;
                itemSelected=2;
            }else if (category.getCategoryResId()==R.drawable.t_shopping){
                binding.icShopping.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_category=ADD_CATEGORY.SELECTED;
                itemSelected=3;
            }else if (category.getCategoryResId()==R.drawable.t_calendar){
                binding.icCalendar.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_category=ADD_CATEGORY.SELECTED;
                itemSelected=4;
            }else if (category.getCategoryResId()==R.drawable.t_study){
                binding.icStudy.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_category=ADD_CATEGORY.SELECTED;
                itemSelected=5;
            }else if (category.getCategoryResId()==R.drawable.other){
                binding.icOther.setBackgroundResource(R.drawable.sh_shape_day_week_done);
                add_category=ADD_CATEGORY.SELECTED;
                itemSelected=6;
            }
            binding.btnSaveTaskCategory.setOnClickListener(v->{
                if (binding.edtTaskCategoryName.getText().length()>2){
                    category.setCategoryName(binding.edtTaskCategoryName.getText().toString());
                    presenter.onEditSaved(category,itemSelected);
                }
            });


        }else if (state==0) {
            Log.i("TAG", "onViewCreated: " + "Null");


            binding.btnSaveTaskCategory.setOnClickListener(v -> {
                presenter.onSaved(binding.edtTaskCategoryName.getText().toString(), itemSelected);

            });
        }
        binding.deleteAddTask.setOnClickListener(v->{
            presenter.onDeleteClicked(category);
        });
        presenter.onAttach(this);
        presenter.fragmentState(state);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void onSaveClicked() {
        Navigation.findNavController(getView()).navigate(FragmentAddCategoryDirections.actionFragmentAddCategoryToFragmentCategory(days));
    }

    @Override
    public void onDeleteIconVisility(boolean isShow) {
        binding.deleteAddTask.setVisibility(isShow?View.VISIBLE:View.GONE);
    }

    @Override
    public void onEdited() {
        Navigation.findNavController(getView()).navigate(FragmentAddCategoryDirections.actionFragmentAddCategoryToFragmentCategory(days));
    }

    @Override
    public void itemDeleted() {
        Navigation.findNavController(getView()).navigate(FragmentAddCategoryDirections.actionFragmentAddCategoryToFragmentCategory(days));

    }

    @Override
    public void onDelete(Category category) {
        builder.setTitle("Delete");
        builder.setMessage("Are You Sure To Delete?");
        builder.setPositiveButton("Yes",(o,p)->{
            presenter.onDeleteConfirmed(category);
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }
}

