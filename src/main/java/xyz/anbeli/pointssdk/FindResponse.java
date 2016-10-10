package xyz.anbeli.pointssdk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public class FindResponse implements Serializable, Parcelable {

    @SerializedName("type")
    private String type;

    @SerializedName("names")
    private DancerName[] names;

    private FindResponse(Parcel in) {
        type = in.readString();
        names = (DancerName[]) in.readParcelableArray(DancerName.class.getClassLoader());
    }

    public static final Creator<FindResponse> CREATOR = new Creator<FindResponse>() {
        @Override
        public FindResponse createFromParcel(Parcel in) {
            return new FindResponse(in);
        }

        @Override
        public FindResponse[] newArray(int size) {
            return new FindResponse[size];
        }
    };

    public String getType() {
        return type;
    }

    public DancerName[] getNames() {
        return names;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeParcelableArray(names, 0);
    }
}
