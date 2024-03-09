package com.example.ce_todolistmvp.Model.model;

import static androidx.room.ForeignKey.CASCADE;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import javax.inject.Inject;

@Entity(tableName = "_category",foreignKeys = {@ForeignKey(entity = Days.class,childColumns = "dayId",parentColumns = "dayId",
onDelete = CASCADE,
onUpdate = CASCADE)})
public class Category implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "catId")
    private int categoryId;
    @ColumnInfo(name = "dayId")
    private int dayId;
    private int categoryResId;
    private int taskCount;
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getCategoryResId() {
        return categoryResId;
    }

    public void setCategoryResId(int categoryResId) {
        this.categoryResId = categoryResId;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.categoryId);
        dest.writeInt(this.dayId);
        dest.writeInt(this.categoryResId);
        dest.writeInt(this.taskCount);
        dest.writeString(this.categoryName);
    }

    public void readFromParcel(Parcel source) {
        this.categoryId = source.readInt();
        this.dayId = source.readInt();
        this.categoryResId = source.readInt();
        this.taskCount = source.readInt();
        this.categoryName = source.readString();
    }
    @Inject
    public Category() {
    }

    protected Category(Parcel in) {
        this.categoryId = in.readInt();
        this.dayId = in.readInt();
        this.categoryResId = in.readInt();
        this.taskCount = in.readInt();
        this.categoryName = in.readString();
    }

    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
