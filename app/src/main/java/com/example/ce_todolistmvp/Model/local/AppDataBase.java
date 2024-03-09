package com.example.ce_todolistmvp.Model.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ce_todolistmvp.Model.model.Category;
import com.example.ce_todolistmvp.Model.model.Days;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.Model.model.Note;
import com.example.ce_todolistmvp.Model.model.Tasks;

@Database(version = 1,exportSchema = false,entities = {Category.class, Days.class, Month.class, Note.class, Tasks.class})
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDataBase;

    public static AppDataBase getAppDataBase(Context context) {
        if (appDataBase==null){
            appDataBase= Room.databaseBuilder(context,AppDataBase.class,"dbOne")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDataBase;
    }
    public abstract Appdao getDao();
}
