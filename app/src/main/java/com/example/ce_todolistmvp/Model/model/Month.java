package com.example.ce_todolistmvp.Model.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import javax.inject.Inject;

@Entity(tableName = "_month")
public class Month implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "monthId")
    private int monthId;
    private String monthName;

    public int getMonthId() {
        return monthId;
    }

    public void setMonthId(int monthId) {
        this.monthId = monthId;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
    @Inject
    public Month(){}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.monthId);
        dest.writeString(this.monthName);
    }

    public void readFromParcel(Parcel source) {
        this.monthId = source.readInt();
        this.monthName = source.readString();
    }

    protected Month(Parcel in) {
        this.monthId = in.readInt();
        this.monthName = in.readString();
    }

    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
        @Override
        public Month createFromParcel(Parcel source) {
            return new Month(source);
        }

        @Override
        public Month[] newArray(int size) {
            return new Month[size];
        }
    };
}
