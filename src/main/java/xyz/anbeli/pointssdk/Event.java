package xyz.anbeli.pointssdk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public class Event implements Serializable, Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private String location;

    @SerializedName("url")
    private String url;

    @SerializedName("date")
    private String date;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy", Locale.US);

    protected Event(Parcel in) {
        id = in.readInt();
        name = in.readString();
        location = in.readString();
        url = in.readString();
        date = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }

    public Date getDate() {
        try {
            return dateFormat.parse(date);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(location);
        parcel.writeString(url);
        parcel.writeString(date);
    }
}
