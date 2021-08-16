package com.example.homework6;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

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
    private String name;
    private String descript;


    public Note(String name) {
        this.name = name;
    }

    protected Note(Parcel in) {
        name = in.readString();
    }

    public String getDescript() {
        return descript;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
