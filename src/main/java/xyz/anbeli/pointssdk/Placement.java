package xyz.anbeli.pointssdk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public class Placement implements Serializable, Parcelable {
    @SerializedName("division")
    private Division division;

    @SerializedName("total_points")
    private int totalPoints;

    @SerializedName("competitions")
    private Competition[] competitions;

    protected Placement(Parcel in) {
        division = in.readParcelable(Division.class.getClassLoader());
        totalPoints = in.readInt();
        competitions = in.createTypedArray(Competition.CREATOR);
    }

    public static final Creator<Placement> CREATOR = new Creator<Placement>() {
        @Override
        public Placement createFromParcel(Parcel in) {
            return new Placement(in);
        }

        @Override
        public Placement[] newArray(int size) {
            return new Placement[size];
        }
    };

    public Division getDivision() {
        return division;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public Competition[] getCompetitions() {
        return competitions;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(division, i);
        parcel.writeInt(totalPoints);
        parcel.writeTypedArray(competitions, i);
    }
}
