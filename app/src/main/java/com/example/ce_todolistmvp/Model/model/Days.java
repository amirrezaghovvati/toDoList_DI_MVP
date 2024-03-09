package com.example.ce_todolistmvp.Model.model;

import static androidx.room.ForeignKey.CASCADE;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import javax.inject.Inject;

@Entity(tableName = "_days",foreignKeys = {@ForeignKey(entity = Month.class,
parentColumns = "monthId",
childColumns = "monthId",
onUpdate = CASCADE,
onDelete = CASCADE)})
public class Days implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dayId")
    private int dayId;
    @ColumnInfo(name = "monthId")
    private int monthId;
    private String dayName;

    private String year;
    private String dayWeek;
    private String month;
    private int resId;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getMonthId() {
        return monthId;
    }

    public void setMonthId(int monthId) {
        this.monthId = monthId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }



    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.dayId);
        dest.writeInt(this.monthId);
        dest.writeString(this.dayName);
        dest.writeString(this.year);
        dest.writeString(this.dayWeek);
        dest.writeString(this.month);
        dest.writeInt(this.resId);
    }

    public void readFromParcel(Parcel source) {
        this.dayId = source.readInt();
        this.monthId = source.readInt();
        this.dayName = source.readString();
        this.year = source.readString();
        this.dayWeek = source.readString();
        this.month = source.readString();
        this.resId = source.readInt();
    }

    @Inject
    public Days() {
    }

    protected Days(Parcel in) {
        this.dayId = in.readInt();
        this.monthId = in.readInt();
        this.dayName = in.readString();
        this.year = in.readString();
        this.dayWeek = in.readString();
        this.month = in.readString();
        this.resId = in.readInt();
    }

    public static final Parcelable.Creator<Days> CREATOR = new Parcelable.Creator<Days>() {
        @Override
        public Days createFromParcel(Parcel source) {
            return new Days(source);
        }

        @Override
        public Days[] newArray(int size) {
            return new Days[size];
        }
    };
}
