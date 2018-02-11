package com.mcsoft.aboutactivity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;

/**
 * Created by biagio on 11/02/18.
 */

public class NoticesParcelable extends Notices implements Parcelable
{

    public List<Notice> list;
    public NoticesParcelable()
    {
        super();
    }

    protected NoticesParcelable(Parcel in)
    {
        super(in);
        in.readList(list, getClass().getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        super.writeToParcel(dest, flags);
        dest.writeList(getNotices());
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Creator<NoticesParcelable> CREATOR = new Creator<NoticesParcelable>()
    {
        @Override
        public NoticesParcelable createFromParcel(Parcel in)
        {
            return new NoticesParcelable(in);
        }

        @Override
        public NoticesParcelable[] newArray(int size)
        {
            return new NoticesParcelable[size];
        }
    };
}
