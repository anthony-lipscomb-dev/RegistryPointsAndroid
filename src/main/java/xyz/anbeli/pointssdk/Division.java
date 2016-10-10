package xyz.anbeli.pointssdk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public class Division implements Serializable, Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("abbreviation")
    private String abbreviation;

    protected Division(Parcel in) {
        id = in.readInt();
        name = in.readString();
        abbreviation = in.readString();
    }

    public static final Creator<Division> CREATOR = new Creator<Division>() {
        @Override
        public Division createFromParcel(Parcel in) {
            return new Division(in);
        }

        @Override
        public Division[] newArray(int size) {
            return new Division[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(abbreviation);
    }
}
