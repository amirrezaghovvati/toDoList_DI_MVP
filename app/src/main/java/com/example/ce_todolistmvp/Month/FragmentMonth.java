package com.example.ce_todolistmvp.Month;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.Model.shared.SignUpAuth;
import com.example.ce_todolistmvp.Month.Adapter.DaggerMonthAdapterComponent;
import com.example.ce_todolistmvp.Month.Adapter.MonthAdapter;
import com.example.ce_todolistmvp.Month.Adapter.MonthAdapterComponent;
import com.example.ce_todolistmvp.Month.AddMonth.AddMonthComponent;
import com.example.ce_todolistmvp.Month.AddMonth.AddMonthDialoge;
import com.example.ce_todolistmvp.Month.AddMonth.DaggerAddMonthComponent;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.databinding.MonthFragmentBinding;

import java.util.List;

import javax.inject.Inject;

public class FragmentMonth extends Fragment implements AddMonthDialoge.AddMonthCallBack, MonthContract.MonthView, MonthAdapter.MonthEventListener {
    private MonthFragmentBinding binding;
    private MonthAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private MonthAdapterComponent adapterComponent;

    private AddMonthComponent addComponent;
    private MonthComponent monthComponent;
    private AddMonthDialoge dialoge;
    @Inject
    AlertDialog.Builder builder;
    @Inject
    MonthContract.MonthPresenter presenter;
    @Inject
    SignUpAuth auth;
    @Inject
    PopupMenu popupMenu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=MonthFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //init
        monthComponent=DaggerMonthComponent.factory().build(getContext(),binding.rvMonthList);
        monthComponent.injectFields(this);
        addComponent=DaggerAddMonthComponent.builder().setCallBack(this).setNamed(new Month()).setStatus(0).build();
        dialoge=addComponent.buildAddMonthDialoge();
        //
        binding.addMonth.setOnClickListener(v->{presenter.onAddClicked();});
        binding.addMonthTv.setOnClickListener(v->{
            presenter.onAddClicked();});
        binding.tvNameMonth.setText(auth.getUserName());
        binding.avatarIc.setImageResource(auth.getProfileRes());


        presenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void onSave(int status,Month month) {
        if (status==0){
         presenter.onAdded(month);
        } else if (status==1){
            presenter.onEdited(month);
        }

    }

    @Override
    public void getMonthList(List<Month> months) {
        adapterComponent= DaggerMonthAdapterComponent.factory().build(months,getContext(),this);
        adapter=adapterComponent.create();
        linearLayoutManager=adapterComponent.buildLayout();
        binding.rvMonthList.setAdapter(adapter);
        binding.rvMonthList.setLayoutManager(linearLayoutManager);
        binding.clearAllIc.setOnClickListener(v->{presenter.onClearAllClicked();});
        binding.quitIc.setOnClickListener(v->{presenter.onExitClicked();});
        binding.avatarIc.setOnClickListener(v->{presenter.onEditProfileClicked();});

    }

    @Override
    public void onStatic(Month month) {
         Navigation.findNavController(getView()).navigate(FragmentMonthDirections.actionFragmentMonthToFragmentStatic(month));
    }

    @Override
    public void onMore(Month month) {

    }



    @Override
    public void onItem(Month month) {
        Navigation.findNavController(getView()).navigate(FragmentMonthDirections.actionFragmentMonthToFragmentDay(month,new Days()));
    }

    @Override
    public void setEmptyStateVisibilit(boolean isShown) {
        binding.emptyStateDay.setVisibility(isShown?View.VISIBLE:View.GONE);
        binding.rvMonthList.setVisibility(isShown?View.GONE:View.VISIBLE);
    }

    @Override
    public void onAdd() {
        dialoge.show(getActivity().getSupportFragmentManager(), null);
    }

    @Override
    public void onAdded(Month month) {
            adapter.addMonth(month);
    }

    @Override
    public void onExit() {
        builder.setTitle("Exit");
        builder.setMessage("Are You Sure To Exit?");
        builder.setPositiveButton("Yes",(o,p)->{
            presenter.onExited();
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }

    @Override
    public void onClearAll() {
        builder.setTitle("Clear All");
        builder.setMessage("Are You Sure To Clear All?");
        builder.setPositiveButton("Yes",(o,p)->{
            presenter.onCleared();
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }

    @Override
    public void onClearAllConfirmed() {
        adapter.clearAll();
    }

    @Override
    public void onExitConfirmed() {
        System.exit(1);
    }

    @Override
    public void onEditProfile() {
            Navigation.findNavController(getView()).navigate(FragmentMonthDirections.actionFragmentMonthToFragmenProfile());
    }

    @Override
    public void onEdit(Month month) {
        addComponent=DaggerAddMonthComponent.builder().setStatus(1).setNamed(month).setCallBack(this).build();
        AddMonthDialoge dialoge1=addComponent.buildAddMonthDialoge();
        dialoge1.show(getActivity().getSupportFragmentManager(), null);
    }

    @Override
    public void onDeleteClicked(Month month) {
        builder.setTitle("Delete");
        builder.setMessage("Are You Sure To Delete?");
        builder.setPositiveButton("Yes",(o,p)->{
            presenter.onDeleteConfirmed(month);
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }

    @Override
    public void onEditClicked(Month month) {
            presenter.onEditClicked(month);

    }

    @Override
    public void onDeleteConfirmed(Month month) {
        adapter.deleteMonth(month);
    }

    @Override
    public void onEdited(Month month) {
        adapter.updateMonth(month);
    }

    @Override
    public void setClearAllBtnVisibility(boolean isShow) {
        binding.clearAllIc.setVisibility(isShow?View.VISIBLE:View.GONE);
    }

    @Override
    public void onItemClicked(Month month) {
            presenter.onItemClicked(month);
    }

    @Override
    public void onStaticClicked(Month month) {
        presenter.onStaticClicked(month);
    }



    @Override
    public void onStart() {
        super.onStart();
        if (auth.getUserName().length()==0){
            Navigation.findNavController(getView()).navigate(FragmentMonthDirections.actionFragmentMonthToNavigation());
        }
    }
}
