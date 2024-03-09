package com.example.ce_todolistmvp.Model.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.Model.model.Note;
import com.example.ce_todolistmvp.Model.model.Tasks;

import java.util.List;

@Dao
public interface Appdao {
    @Insert
    long addMonth(Month month);
    @Query("select * from _month ")
    List<Month> getAllMonth();
    @Delete
    int deleteMonth(Month month);
    @Update
    int updateMonth(Month month);
    @Query("Delete From _month")
    void clearAllMonth();
    //
    @Insert
    long addDays(Days days);
    @Query("Select * From _days where monthId like :id")
    List<Days> getAllDays(int id);
    @Delete
    int deleteDays(Days days);
    @Update
    int updateDays(Days days);
    @Query("Delete From _days where monthId like:id")
    void clearAllDays(int id);
    //

    @Insert
    long addCategory(Category category);
    @Query("Select * From _category where dayId like :id")
    List<Category> getAllCategory(int id);
    @Delete
    int deleteCategory(Category category);
    @Update
    int updateCategory(Category category);
    @Query("Delete From _category where dayId like :id")
    void clearAllCategory(int id);
    //
    @Insert
    long addTasks(Tasks tasks);
    @Query("Select * From _tasks where catId like:id")
    List<Tasks> getAllTasks(int id);
    @Delete
    int deleteTasks(Tasks tasks);
    @Update
    int updateTasks(Tasks tasks);
    @Query("Delete From _tasks where catId like :id")
    void clearAllTasks(int id);
    //
    @Insert
    long addNote(Note note);
    @Query("Select * From _note where dayId like :dayId")
    List<Note> getAllNote(int dayId);
    @Delete
    int deleteNote(Note note);
    @Update
    int updateNote(Note note);
    @Query("Delete From _note where dayId like :id")
    void clearAllNote(int id);
}
