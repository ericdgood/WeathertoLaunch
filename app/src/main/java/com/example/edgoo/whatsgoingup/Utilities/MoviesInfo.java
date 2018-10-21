package com.example.edgoo.whatsgoingup.Utilities;

import android.os.Parcel;
import android.os.Parcelable;

public class MoviesInfo implements Parcelable {

    private String rocket;
    private String location;
    private String windowStart;
    private String windowEnd;
    private String rocketImage;

    private MoviesInfo(Parcel in) {
        rocket = in.readString();
        windowStart = in.readString();
        location = in.readString();
        rocketImage = in.readString();
        windowEnd = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rocket);
        dest.writeString(location);
        dest.writeString(windowStart);
        dest.writeString(rocketImage);
        dest.writeString(windowEnd);
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
    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }


    public String getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(String windowStart) {
        this.windowStart = windowStart;
    }

    public String getRocketImage() {
        return rocketImage;
    }

    public void setRocketImage(String rocketImage) {
        this.rocketImage = rocketImage;
    }


    public String getWindowEnd() {
        return windowEnd;
    }

    public void setWindowEnd(String windowEnd) {
        this.windowEnd = windowEnd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

