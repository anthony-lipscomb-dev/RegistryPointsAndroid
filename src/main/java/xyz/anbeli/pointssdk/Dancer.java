package xyz.anbeli.pointssdk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public class Dancer implements Serializable, Parcelable {
    @SerializedName("type")
    private String type;

    @SerializedName("dancer")
    private DancerName details;

    @SerializedName("placements")
    private Placements placement;

    protected Dancer(Parcel in) {
        type = in.readString();
        details = in.readParcelable(DancerName.class.getClassLoader());
        placement = in.readParcelable(Placements.class.getClassLoader());
    }

    public static final Creator<Dancer> CREATOR = new Creator<Dancer>() {
        @Override
        public Dancer createFromParcel(Parcel in) {
            return new Dancer(in);
        }

        @Override
        public Dancer[] newArray(int size) {
            return new Dancer[size];
        }
    };

    public String getType() {
        return type;
    }

    public DancerName getDetails() {
        return details;
    }

    public Placement[] getWCSPlacements() {
        return placement.getPlacements();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeParcelable(details, i);
        parcel.writeParcelable(placement, i);
    }
}
