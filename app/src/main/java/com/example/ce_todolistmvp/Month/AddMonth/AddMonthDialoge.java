package com.example.ce_todolistmvp.Month.AddMonth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.R;
import com.google.android.material.button.MaterialButton;

import javax.inject.Inject;
import javax.inject.Named;

public class AddMonthDialoge extends DialogFragment {
    private AddMonthCallBack callBack;
    private int status=0;
    private Month monthName;
    @Inject Month month;
    private AddMonthDialogMonth component;
    @Inject
    public AddMonthDialoge(@Named("callBack") AddMonthCallBack callBack,@Named("status")int status,@Named("monthName")Month monthName){
        this.callBack=callBack;
        this.status=status;
        this.monthName=monthName;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        component=DaggerAddMonthDialogMonth.create();
        component.injectFields(this);
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        View view= LayoutInflater.from(getContext()).inflate(R.layout.add_simple_task_dialoge,null,false);
        TextView tvTitle=view.findViewById(R.id.tvAddTitle);
        EditText edtMonth=view.findViewById(R.id.edtTaskTitle);
        MaterialButton btnConfirm=view.findViewById(R.id.taskTitleConfirm);
        MaterialButton btnCancel=view.findViewById(R.id.taskTitleCancel);
        tvTitle.setText("Add Month");
        if (status==1){
            edtMonth.setText(monthName.getMonthName());
            month.setMonthId(monthName.getMonthId());
            btnConfirm.setOnClickListener(v->{
                if (edtMonth.getText().length()>3){
                    monthName.setMonthName(edtMonth.getText().toString());

                    callBack.onSave(1,monthName);
                    dismiss();
                }else{
                    Toast.makeText(getContext(),"Please Complete The Fields Completely!",Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            });
        }else
           btnConfirm.setOnClickListener(v->{
            if (edtMonth.getText().length()>3){
                month.setMonthName(edtMonth.getText().toString());
                callBack.onSave(0,month);
                dismiss();
            }else{
                Toast.makeText(getContext(),"Please Complete The Fields Completely!",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        btnCancel.setOnClickListener(v -> {
            dismiss();
        });

        return builder.setView(view).create();
    }
    public interface AddMonthCallBack{
        void onSave(int status, Month month);
    }
}
