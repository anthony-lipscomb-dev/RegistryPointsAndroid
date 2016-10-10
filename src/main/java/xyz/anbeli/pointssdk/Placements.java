package xyz.anbeli.pointssdk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public class Placements implements Serializable, Parcelable {
    @SerializedName("West Coast Swing")
    private Placement[] placements;

    protected Placements(Parcel in) {
        placements = in.createTypedArray(Placement.CREATOR);
    }

    public static final Creator<Placements> CREATOR = new Creator<Placements>() {
        @Override
        public Placements createFromParcel(Parcel in) {
            return new Placements(in);
        }

        @Override
        public Placements[] newArray(int size) {
            return new Placements[size];
        }
    };

    public Placement[] getPlacements() {
        return placements;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(placements, i);
    }
}
