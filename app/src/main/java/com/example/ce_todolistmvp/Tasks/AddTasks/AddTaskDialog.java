package com.example.ce_todolistmvp.Tasks.AddTasks;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.ce_todolistmvp.Model.model.Tasks;
import com.example.ce_todolistmvp.databinding.AddSimpleTaskDialogeBinding;

import javax.inject.Inject;
import javax.inject.Named;

import kotlin.jvm.JvmInline;

public class AddTaskDialog extends DialogFragment {
    AddSimpleTaskDialogeBinding binding;

    AlertDialog.Builder builder;
     Tasks tasks;
    private AddTaskDialogComponent component;
    private AddTaskDialogCallBack callBack;
    @Inject
    public AddTaskDialog(@Named("callBack") AddTaskDialogCallBack callBack){
        this.callBack=callBack;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        component=DaggerAddTaskDialogComponent.factory().build(getContext());
        tasks=component.buildTasks();
        builder=component.buildAlertBuilder();
        //
        binding=AddSimpleTaskDialogeBinding.inflate(LayoutInflater.from(getContext()),null,false);
        builder.setView(binding.getRoot());
        binding.taskTitleConfirm.setOnClickListener(v->{
            if (binding.edtTaskTitle.getText().length()>3){
                tasks.setTitle(binding.edtTaskTitle.getText().toString());
                callBack.onSaveClicked(tasks);
                dismiss();
            }
        });
        binding.taskTitleCancel.setOnClickListener(v->{
            dismiss();
        });
        return builder.create();
    }
    public interface AddTaskDialogCallBack{
        void onSaveClicked(Tasks tasks);
    }
}
