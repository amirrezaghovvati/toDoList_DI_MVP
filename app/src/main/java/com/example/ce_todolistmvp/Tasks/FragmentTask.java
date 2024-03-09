package com.example.ce_todolistmvp.Tasks;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Tasks;

import com.example.ce_todolistmvp.Tasks.Adapter.DaggerTaskAdapterComponent;
import com.example.ce_todolistmvp.Tasks.Adapter.TaskAdapter;
import com.example.ce_todolistmvp.Tasks.Adapter.TaskAdapterComponent;
import com.example.ce_todolistmvp.Tasks.AddTasks.AddTaskComponent;
import com.example.ce_todolistmvp.Tasks.AddTasks.AddTaskDialog;
import com.example.ce_todolistmvp.Tasks.AddTasks.DaggerAddTaskComponent;
import com.example.ce_todolistmvp.databinding.DetailFragmentBinding;

import java.util.List;

import javax.inject.Inject;


public class FragmentTask extends Fragment implements TaskContract.TaskView, AddTaskDialog.AddTaskDialogCallBack, TaskAdapter.TaskEventListener {
    DetailFragmentBinding binding;
    @Inject
    TaskContract.TaskPresenter presenter;
    @Inject
    AlertDialog.Builder builder;
    private TaskPresenterComponent component;

    private TaskAdapterComponent taskComponent;
    private TaskAdapter taskAdapter;
    private LinearLayoutManager layoutManager;



    private Category category;
    private AddTaskComponent addTaskComponent;
    private AddTaskDialog addTaskDialog;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        category=FragmentTaskArgs.fromBundle(getArguments()).getCategory();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=DetailFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        component=DaggerTaskPresenterComponent.factory().build(category,getContext());
        component.injectFields(this);
        binding.ivTaskTypeDetail.setImageResource(category.getCategoryResId());
        binding.tvCategoryDetail.setText(category.getCategoryName());
        binding.clearAllDetail.setOnClickListener(v->{
            presenter.onClearAllClicked();
        });
   
        binding.tvAddDetailTask.setOnClickListener(v->{presenter.onAddClicked();});
        binding.addTaskDetail.setOnClickListener(v->{presenter.onAddClicked();});
        addTaskComponent= DaggerAddTaskComponent.factory().build(this);
        addTaskDialog=addTaskComponent.buildTaskDialoge();
        binding.icBackDetail.setOnClickListener(v->{
            presenter.onBackClicked();
        });
        presenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void getTaskList(List<Tasks> tasks) {
            taskComponent= DaggerTaskAdapterComponent.factory().build(tasks,this,getContext());
            layoutManager=taskComponent.buildLayout();
            taskAdapter=taskComponent.buildAdapter();
            binding.rvDetail.setLayoutManager(layoutManager);
            binding.rvDetail.setAdapter(taskAdapter);



    }

    @Override
    public void deleteTasks(Tasks tasks) {
        taskAdapter.deleteTasks(tasks);
    }

    @Override
    public void onAdd(){
        addTaskDialog.show(getActivity().getSupportFragmentManager(), null);
    }

    @Override
    public void clearAll() {
        builder.setTitle("Clear All");
        builder.setMessage("Are You Sure To Clear All?");
        builder.setPositiveButton("Yes",(o,p)->{
            presenter.onClearAllConfirmed();
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }

    @Override
    public void clearAllConfirmed() {
        taskAdapter.clearAllTasks();
    }

    @Override
    public void setClearAllIconVisility(boolean isShown) {
        binding.emptyStateDetail.setVisibility(isShown?View.VISIBLE:View.GONE);
        binding.clearAllDetail.setVisibility(isShown?View.GONE:View.VISIBLE);
    }

    @Override
    public void onAdde(Tasks tasks) {
        taskAdapter.addTasks(tasks);
        }

    @Override
    public void updateTasks(Tasks tasks) {
        taskAdapter.updateTasks(tasks);
    }

    @Override
    public void onBack() {
        getActivity().onBackPressed();
    }

    @Override
    public void getSize(int size) {
        binding.tvTaskCountDetail.setText(size+" Tasks");
    }


    @Override
    public void onSaveClicked(Tasks tasks) {
        presenter.onAdded(tasks);
    }

    @Override
    public void onDeleteClicked(Tasks tasks) {
        presenter.onDelteClickeD(tasks);
    }

    @Override
    public void onDoneClicked(Tasks tasks) {
        presenter.onUpdate(tasks);
    }
}
