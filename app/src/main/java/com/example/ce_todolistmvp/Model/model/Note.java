package com.example.ce_todolistmvp.Model.model;

import static androidx.room.ForeignKey.CASCADE;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "_note",foreignKeys = {@ForeignKey(entity = Days.class,
onUpdate = CASCADE,
onDelete = CASCADE,
childColumns = "dayId",
parentColumns = "dayId")})
public class Note implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int noteId;
    private String note;
    @ColumnInfo(name = "dayId")
    private int dayId;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.noteId);
        dest.writeString(this.note);
        dest.writeInt(this.dayId);
    }

    public void readFromParcel(Parcel source) {
        this.noteId = source.readInt();
        this.note = source.readString();
        this.dayId = source.readInt();
    }

    public Note() {
    }

    protected Note(Parcel in) {
        this.noteId = in.readInt();
        this.note = in.readString();
        this.dayId = in.readInt();
    }

    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
