package xyz.anbeli.pointssdk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public class Competition implements Serializable, Parcelable {
    @SerializedName("role")
    private String role;

    @SerializedName("points")
    private int points;

    @SerializedName("event")
    private Event event;

    @SerializedName("result")
    private String result;

    protected Competition(Parcel in) {
        role = in.readString();
        points = in.readInt();
        event = in.readParcelable(Event.class.getClassLoader());
        result = in.readString();
    }

    public static final Creator<Competition> CREATOR = new Creator<Competition>() {
        @Override
        public Competition createFromParcel(Parcel in) {
            return new Competition(in);
        }

        @Override
        public Competition[] newArray(int size) {
            return new Competition[size];
        }
    };

    public String getRole() {
        return role;
    }

    public int getPoints() {
        return points;
    }

    public Event getEvent() {
        return event;
    }

    public String getResult() {
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(role);
        parcel.writeInt(points);
        parcel.writeParcelable(event, i);
        parcel.writeString(result);
    }
}
