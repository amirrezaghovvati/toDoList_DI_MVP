package com.example.ce_todolistmvp.Category.Category;

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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Category.Category.Adapter.CategoryAdapter;
import com.example.ce_todolistmvp.Category.Category.Adapter.CategoryAdapterComponent;
import com.example.ce_todolistmvp.Category.Category.Adapter.DaggerCategoryAdapterComponent;
import com.example.ce_todolistmvp.Category.Category.Adapter.DaggerInCategoryAdapterComponent;
import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.databinding.TaskCategoryFragmentBinding;

import java.util.List;

import javax.inject.Inject;

public class FragmentCategory extends Fragment implements CategoryContract.CatView,CategoryAdapter.CategoryEventListener{
    TaskCategoryFragmentBinding binding;

    private CategoryAdapterComponent adapterComponent;
    private CategoryAdapter adapter;
    private LinearLayoutManager layoutManager;
    @Inject CategoryContract.CatPresenter presenter;
    @Inject
    AlertDialog.Builder builder;
    private CategoryComponent component;
    private Days days;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        days=FragmentCategoryArgs.fromBundle(getArguments()).getDays();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=TaskCategoryFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        component=DaggerCategoryComponent.factory().build(days,getContext());
        component.injectFields(this);
        binding.tvDateTaskCat.setText(days.getYear()+"/"+days.getMonth()+"/"+days.getDayWeek());
        binding.tvDayNameTaskCat.setText(days.getDayName());
        binding.icDayWeekCategory.setImageResource(days.getResId());
        binding.backArrowTaskCat.setOnClickListener(v->{presenter.onBackClicked();});
        binding.tvAddTaskCategory.setOnClickListener(v->{
            presenter.onAddClicked(days);
        });
        binding.categoryBtnAddTaskCat.setOnClickListener(v->{
            presenter.onAddClicked(days);
        });
        binding.clearAllCategory.setOnClickListener(v->{presenter.onClearAllClicked();});


        presenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void setList(List<Category> categories) {
            adapterComponent= DaggerCategoryAdapterComponent.factory().build(this,categories,getContext());
            adapter=adapterComponent.buildAdapter();
            layoutManager=adapterComponent.buildLayout();
            binding.rvTaskCat.setAdapter(adapter);
            binding.rvTaskCat.setLayoutManager(layoutManager);
    }

    @Override
    public void setEmptyStateVisibiilt(boolean isShown) {
        binding.emptyStateTaskCat.setVisibility(isShown?View.VISIBLE:View.GONE);
        binding.rvTaskCat.setVisibility(isShown?View.GONE:View.VISIBLE);
        binding.clearAllCategory.setVisibility(isShown?View.GONE:View.VISIBLE);
    }

    @Override
    public void onBack() {
        getActivity().onBackPressed();
    }

    @Override
    public void onAddClicked(Days days) {
        Navigation.findNavController(getView()).navigate(FragmentCategoryDirections.actionFragmentCategoryToFragmentAddCategory(days,new Category(),0));
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
    public void onClearAllConfirmed() {
        adapter.clearAll();
    }

    @Override
    public void onDelete(Category category) {
        adapter.deleteItem(category);
    }

    @Override
    public void onUpdate(Category category) {
        Navigation.findNavController(getView()).navigate(FragmentCategoryDirections.actionFragmentCategoryToFragmentAddCategory(days,category,1));
    }

    @Override
    public void onItem(Category category) {
       Navigation.findNavController(getView()).navigate(FragmentCategoryDirections.actionFragmentCategoryToFragmentTask(category));
    }


    @Override
    public void onItemClicked(Category category) {
        presenter.onItemClicked(category);
    }

    @Override
    public void onDeleteItemClicked(Category category) {
        presenter.onDeleteClicked(category);
    }

    @Override
    public void onUpdateItemClicked(Category category) {
        presenter.onUpdateClicked(category);
    }

    @Override
    public int size(Category category) {
        return presenter.size(category);
    }
}
