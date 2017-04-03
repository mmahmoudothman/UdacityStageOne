package app.com.example.mmahmoudothmaon.udacityone;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable{





    private String mTitle;
    private Double mVoteAverage;
    private String mOverview;
    private String mReleaseDate;
    private Long mId;
    private String mPosterPath;
    private String mOriginalTitle;

    protected Movie(Parcel in) {
        mOriginalTitle = in.readString();
        mOverview = in.readString();
        mPosterPath = in.readString();
        mReleaseDate = in.readString();
        mId = in.readLong();
        mVoteAverage = in.readDouble();
    }
///the Parcable interface implementation
    public static final Creator<Movie> CREATOR = new Creator<Movie>()
    {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public Movie()
    {
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mOriginalTitle);
        parcel.writeString(mOverview);
        parcel.writeString(mPosterPath);
        parcel.writeString(mReleaseDate);
        parcel.writeLong(mId);
        parcel.writeDouble(mVoteAverage);
    }
    public static Creator<Movie> getCREATOR()
    {
        return CREATOR;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }



    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }


}
