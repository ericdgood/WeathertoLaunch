package com.example.edgoo.whatsgoingup.Utilities;

import android.os.Parcel;
import android.os.Parcelable;

public class MoviesInfo implements Parcelable {

    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }

    private String rocket;

    private MoviesInfo(Parcel in) {
        rocket = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rocket);
    }

    MoviesInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MoviesInfo> CREATOR = new Creator<MoviesInfo>() {
        @Override
        public MoviesInfo createFromParcel(Parcel in) {
            return new MoviesInfo(in);
        }

        @Override
        public MoviesInfo[] newArray(int size) {
            return new MoviesInfo[size];
        }
    };

    }

