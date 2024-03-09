package com.example.ce_todolistmvp.Model.model;

import static androidx.room.ForeignKey.CASCADE;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import javax.inject.Inject;

@Entity(tableName = "_tasks",foreignKeys = {@ForeignKey(entity = Category.class,parentColumns = "catId",
childColumns = "catId",
onUpdate = CASCADE,
onDelete = CASCADE)})
public class Tasks implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "taskId")
    private int taskId;
    @ColumnInfo(name = "catId")
    private int catId;
    private String title;
    private boolean isDone;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.taskId);
        dest.writeInt(this.catId);
        dest.writeString(this.title);
        dest.writeByte(this.isDone ? (byte) 1 : (byte) 0);
    }

    public void readFromParcel(Parcel source) {
        this.taskId = source.readInt();
        this.catId = source.readInt();
        this.title = source.readString();
        this.isDone = source.readByte() != 0;
    }
    @Inject
    public Tasks() {
    }

    protected Tasks(Parcel in) {
        this.taskId = in.readInt();
        this.catId = in.readInt();
        this.title = in.readString();
        this.isDone = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Tasks> CREATOR = new Parcelable.Creator<Tasks>() {
        @Override
        public Tasks createFromParcel(Parcel source) {
            return new Tasks(source);
        }

        @Override
        public Tasks[] newArray(int size) {
            return new Tasks[size];
        }
    };
}
