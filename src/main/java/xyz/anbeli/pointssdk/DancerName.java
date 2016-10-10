package xyz.anbeli.pointssdk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public class DancerName implements Serializable, Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("wscid")
    private int wscid;

    private DancerName(Parcel in) {
        id = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        wscid = in.readInt();
    }

    public static final Creator<DancerName> CREATOR = new Creator<DancerName>() {
        @Override
        public DancerName createFromParcel(Parcel in) {
            return new DancerName(in);
        }

        @Override
        public DancerName[] newArray(int size) {
            return new DancerName[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getWscid() {
        return wscid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeInt(wscid);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + wscid + ")";
    }
}
