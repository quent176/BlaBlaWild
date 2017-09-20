package fr.wcs.blablawild;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class SearchRequestModel implements Parcelable {
    private String CityDeparture;
    private String CityArrival;
    private Date DateTrip;

    public SearchRequestModel (String CityDeparture, String CityArrival, Date DateTrip) {
        super();
        this.CityDeparture = CityDeparture;
        this.CityArrival = CityArrival;
        this.DateTrip = DateTrip;
    }

    public String getCityDeparture() {
        return CityDeparture;
    }

    public void setCityDeparture(String cityDeparture) {
        CityDeparture = cityDeparture;
    }

    public String getCityArrival() {
        return CityArrival;
    }

    public void setCityArrival(String cityArrival) {
        CityArrival = cityArrival;
    }

    public Date getDateTrip() {
        return DateTrip;
    }

    public void setDateTrip(Date dateTrip) {
        DateTrip = dateTrip;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.CityDeparture);
        dest.writeString(this.CityArrival);
        dest.writeLong(this.DateTrip.getTime());
    }

    public static final Parcelable.Creator<SearchRequestModel> CREATOR = new Parcelable.Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };

    private SearchRequestModel(Parcel in) {
        this.CityDeparture = in.readString();
        this.CityArrival = in.readString();
        this.DateTrip = new Date(in.readLong());

    }

}
