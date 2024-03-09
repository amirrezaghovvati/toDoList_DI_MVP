package com.example.ce_todolistmvp.Category.Category.Adapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.databinding.TaskItemBinding;

import java.util.List;

import javax.inject.Inject;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private TaskItemBinding binding;
    private List<Category> categoryList;
    private CategoryEventListener eventListener;
    private PopupMenu popupMenu;
    private InCategoryAdapterComponent component;
    @Inject
    public CategoryAdapter(List<Category> categoryList,CategoryEventListener eventListener){
        this.categoryList=categoryList;
        this.eventListener=eventListener;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=TaskItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false   );
        return new CategoryViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.bindCategory(categoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bindCategory(Category category){
            itemView.setOnClickListener(v->{eventListener.onItemClicked(category);});
            binding.tvTaskTypeTaskItem.setText(category.getCategoryName());
            binding.ivTaskTypeTaskItem.setImageResource(category.getCategoryResId());
            binding.moreTaskItem.setOnClickListener(v->{
                component=DaggerInCategoryAdapterComponent.factory().build(v.getContext(),v);
                popupMenu=component.buildPopUpMenu();
                popupMenu.getMenuInflater().inflate(R.menu.month_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId()==R.id.deleteMonth){
                            eventListener.onDeleteItemClicked(category);
                        }else if (item.getItemId()==R.id.editMonth){
                            eventListener.onUpdateItemClicked(category);
                        }
                        return false;
                    }
                });
            });
             binding.tvTaskNumberTaskItem.setText(category.getTaskCount()+" Tasks");
        }
    }

    public void clearAll(){
        this.categoryList.clear();
        notifyDataSetChanged();
    }
    public void deleteItem(Category category){
        this.categoryList.remove(category);
        notifyItemRemoved(this.categoryList.indexOf(category));
    }
    public void updateItem(Category category){
        notifyDataSetChanged();
    }
    public interface CategoryEventListener{
        void onItemClicked(Category category);
        void onDeleteItemClicked(Category category);
        void onUpdateItemClicked(Category category);
        int size(Category category);

    }
}
