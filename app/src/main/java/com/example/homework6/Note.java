package com.example.homework6;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    
    private String name;
    private int descript;

    public Note(String name, int descript) {
        this.name = name;
        this.descript = descript;
    }

    protected Note(Parcel in) {
        name = in.readString();
        descript = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public Note(String s) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDescript() {
        return descript;
    }

    public void setDescript(int descript) {
        this.descript = descript;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(descript);
    }
}

