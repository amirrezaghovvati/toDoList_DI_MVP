package com.example.ce_todolistmvp.Days.day.Adapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.databinding.DayItemBinding;

import java.util.List;

import javax.inject.Inject;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayViewHolder> {
    private List<Days> days;
    private DayAdapterEvents events;
    private InDayAdapterComponent component;
    private PopupMenu popupMenu;

    @Inject
    public DayAdapter(List<Days> days,DayAdapterEvents events){
        this.days=days;
        this.events=events;
    }
    private DayItemBinding binding;

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=DayItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new DayViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        holder.bindDays(days.get(position));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class DayViewHolder extends RecyclerView.ViewHolder {

        public DayViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        public void bindDays(Days days){

            binding.dayIcMore.setOnClickListener(v->{
                component=DaggerInDayAdapterComponent.factory().build(v.getContext(),v );
                popupMenu=component.buildPopUp();
                popupMenu.getMenuInflater().inflate(R.menu.month_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(item -> {
                    if (item.getItemId()==R.id.deleteMonth){
                        events.onDeleteClicked(days);
                    }else if (item.getItemId()==R.id.editMonth){
                        events.onEditClicked(days);
                    }

                    return false;
                });
            });
            itemView.setOnClickListener(v->{
                events.onClicked(days);
            });

            binding.dayWeekItem.setImageResource(days.getResId());
            binding.dayTvDate.setText(days.getYear()+"/"+days.getMonth()+"/"+days.getDayWeek());
            binding.dayTvDayWeek.setText(days.getDayName());
        }
    }
    public void deleteItem(Days days){
        this.days.remove(days);
        notifyItemRemoved(this.days.indexOf(days));
    }
    public void clearAllItem(){
        this.days.clear();
        notifyDataSetChanged();
    }

    public interface DayAdapterEvents{
        void onClicked(Days days);

        void onDeleteClicked(Days days);
        void onEditClicked(Days days);
    }
}
