package com.example.ce_todolistmvp.Tasks.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ce_todolistmvp.Model.model.Tasks;
import com.example.ce_todolistmvp.R;

import java.util.List;

import javax.inject.Inject;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private InTaskAdapterComponent component;
    List<Tasks> tasks;
    private TaskEventListener eventListener;
    @Inject
    public TaskAdapter(List<Tasks> tasks,TaskEventListener eventListener){
        this.tasks=tasks;
        this.eventListener=eventListener;
    }
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_task_item,parent,false );
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bindTasks(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private ImageView icDelete;
        private ImageView icDone;
        private TextView tvTitle;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            component=DaggerInTaskAdapterComponent.create();
            component.injectFields(TaskAdapter.this);
            icDelete=itemView.findViewById(R.id.deleteTaskTitleIcon);
            icDone=itemView.findViewById(R.id.detailCheckedState);
            tvTitle=itemView.findViewById(R.id.tvTitleTasks);
        }
        public void bindTasks(Tasks tasks){
            if (tasks.isDone()) {
                icDone.setImageResource(R.drawable.done_ic);
            }else {
                icDone.setImageResource(R.drawable.un_done_ic);
            }
            icDone.setOnClickListener(v->{
                if (tasks.isDone()){
                    tasks.setDone(false);
                }else {
                    tasks.setDone(true);
                }
                eventListener.onDoneClicked(tasks);
            });
            tvTitle.setText(tasks.getTitle());
            icDelete.setOnClickListener(v->{
                eventListener.onDeleteClicked(tasks);
            });
        }
    }
    public void addTasks(Tasks tasks){
        this.tasks.add(0,tasks);
        notifyItemInserted(0);
    }
    public void updateTasks(Tasks tasks){
        int index=this.tasks.indexOf(tasks);
        this.tasks.set(index,tasks);
        notifyItemChanged(index);
    }
    public void clearAllTasks(){
        this.tasks.clear();
        notifyDataSetChanged();
    }
    public void deleteTasks(Tasks tasks){
        int index=this.tasks.indexOf(tasks);
        this.tasks.remove(index);
        notifyItemRemoved(index);
    }
    public interface TaskEventListener{
        void onDeleteClicked(Tasks tasks);
        void onDoneClicked(Tasks tasks);
    }
}
