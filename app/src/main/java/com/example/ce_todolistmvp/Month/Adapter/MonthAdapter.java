package com.example.ce_todolistmvp.Month.Adapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.databinding.MonthItemBinding;

import java.util.List;

import javax.inject.Inject;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MonthViewHolder> {
    private List<Month> months;
    private MonthEventListener eventListener;
    private PopupMenu popupMenu;
    private InMonthAdapterComponent component;
    @Inject
    public MonthAdapter(List<Month> months,MonthEventListener eventListener){
        this.months=months;
        this.eventListener=eventListener;
    }

    @NonNull
    @Override
    public MonthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.month_item,parent,false);
        return new MonthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthViewHolder holder, int position) {
        holder.bindMonth(months.get(position));
    }

    @Override
    public int getItemCount() {
        return months.size();
    }

    public void addMonth(Month month){
        this.months.add(0,month);
        notifyItemInserted(0);
    }
    public void updateMonth(Month month){
        int index= months.indexOf(month);
        months.set(index,month);
        notifyItemChanged(index);


    }
    public void deleteMonth(Month month){
        int index=months.indexOf(month);
        months.remove(month);
        notifyItemRemoved(index);
    }
    public void clearAll(){
        this.months.clear();
        notifyDataSetChanged();
    }
    public class MonthViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMonth;
        private ImageView imgChart;
        private ImageView icMore;
        public MonthViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMonth=itemView.findViewById(R.id.tvMonth);
            imgChart=itemView.findViewById(R.id.ivStatic);
            icMore=itemView.findViewById(R.id.moreMonth);

        }
        public void bindMonth(Month month){
            tvMonth.setText(month.getMonthName());
            imgChart.setOnClickListener(v->{
                eventListener.onStaticClicked(month);
            });
            icMore.setOnClickListener(v->{
                component=DaggerInMonthAdapterComponent.factory().build(v.getContext(),v);
                popupMenu=component.buildPopUp();
                popupMenu.getMenuInflater().inflate(R.menu.month_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(item -> {
                    if (item.getItemId()==R.id.deleteMonth){
                        eventListener.onDeleteClicked(month);
                    } else if (item.getItemId()==R.id.editMonth) {
                        eventListener.onEditClicked(month);
                    }
                    return false;
                });
            });
            itemView.setOnClickListener(v->{
                eventListener.onItemClicked(month);
            });
        }
    }


    public interface MonthEventListener{
        void onItemClicked(Month month);
        void onStaticClicked(Month month);
        void onDeleteClicked(Month month);
        void onEditClicked(Month month);
    }
}
