package com.example.ce_todolistmvp.Days.day;

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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Days.day.Adapter.DaggerDayAdapterComponent;
import com.example.ce_todolistmvp.Days.day.Adapter.DayAdapter;
import com.example.ce_todolistmvp.Days.day.Adapter.DayAdapterComponent;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.Model.shared.SignUpAuth;

import com.example.ce_todolistmvp.databinding.DayFragmentBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class FragmentDay extends Fragment implements DayContract.DayView, DayAdapter.DayAdapterEvents {
    @Inject
    DayContract.DayPresenter presenter;
    @Inject AlertDialog.Builder builder;


    private DayFragmentBinding binding;
    private DayAdapter dayAdapter;
    private LinearLayoutManager layoutManager;
    private DayAdapterComponent adapterComponent;
    private Month month;

    private DayComponent component;
    private Days days;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        month=FragmentDayArgs.fromBundle(getArguments()).getMonth();
        days=FragmentDayArgs.fromBundle(getArguments()).getDays();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=DayFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        component=DaggerDayComponent.factory().build(getContext(),month);
        component.injectFields(this);
        //
        binding.tvMonthName.setText(month.getMonthName());
        binding.backDay.setOnClickListener(v->{presenter.onBakcClicked();});
        binding.clearAllIc.setOnClickListener(v->{presenter.onClearAllClicked();});
        //
        binding.tvAddDay.setOnClickListener(v->{
            presenter.onAddDayClicked();
        });
        binding.dayAddDayBtn.setOnClickListener(v->{
            presenter.onAddDayClicked();
        });


        binding.clearAllIc.setOnClickListener(v->{
            presenter.onClearAllClicked();
        });

        presenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void getList(List<Days> days) {
        adapterComponent= DaggerDayAdapterComponent.factory().build(getContext(),this,days);
        dayAdapter=adapterComponent.buildAdapter();
        layoutManager=adapterComponent.buildLinearLayoutManager();
        binding.rvDayList.setAdapter(dayAdapter);
        binding.rvDayList.setLayoutManager(layoutManager);
    }

    @Override
    public void onAdd() {
        Navigation.findNavController(getView()).navigate(FragmentDayDirections.actionFragmentDayToFragmentAddDay(month,new Days()).setState(0));
    }

    @Override
    public void emptyStateVisibility(boolean isShown) {
        binding.emptyStateDay.setVisibility(isShown?View.VISIBLE:View.GONE);
        binding.rvDayList.setVisibility(isShown?View.GONE:View.VISIBLE);
        binding.clearAllIc.setVisibility(isShown?View.GONE:View.VISIBLE);
    }



    @Override
    public void onItem(Days days) {
            Navigation.findNavController(getView()).navigate(FragmentDayDirections.actionFragmentDayToFragmentCategory(days));
    }

    @Override
    public void onBack() {
        getActivity().onBackPressed();
    }

    @Override
    public void onClearAll() {
        builder.setTitle("Clear All");
        builder.setMessage("Are You Sure To Clear All?");
        builder.setPositiveButton("Yes",(o,p)->{
            presenter.onClearAllConfirmed();
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }

    @Override
    public void onClearAllConfirm() {
        dayAdapter.clearAllItem();
    }

    @Override
    public void onDelete(Days days) {
        dayAdapter.deleteItem(days);
    }


    @Override
    public void onClicked(Days days) {
            presenter.onItemClicked(days);
    }

    @Override
    public void onDeleteClicked(Days days) {
        presenter.onDeleteClicked(days);
    }

    @Override
    public void onEditClicked(Days days) {
        presenter.onUpdateClicked(days);
    }


    @Override
    public void onUpdate(Days days) {
        Navigation.findNavController(getView()).navigate(FragmentDayDirections.actionFragmentDayToFragmentAddDay(month,days).setState(1));
    }

}
