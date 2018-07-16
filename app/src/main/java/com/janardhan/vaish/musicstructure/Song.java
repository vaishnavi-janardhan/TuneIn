package com.janardhan.vaish.musicstructure;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable{

    private String mSongName;
    private String mArtistName;

    /** Image resource id for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;


    public Song(String songName, String artistName, int imageResourceId){
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
    }

    //Passing object using Parcelable
    protected Song(Parcel in) {
        mSongName = in.readString();
        mArtistName = in.readString();
        mImageResourceId = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    /**
     * Get the name of the song
     * @return
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the name of the artist
     * @return
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the Resource Id of the image
     * @return
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param out  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mSongName);
        out.writeString(mArtistName);
        out.writeInt(mImageResourceId);
    }
}
