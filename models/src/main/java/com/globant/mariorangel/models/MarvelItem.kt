package com.globant.mariorangel.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class MarvelItem(@SerializedName("resourceURI") var resourceUri: String? = "",
                 @SerializedName("name") var name: String? = ""): RealmObject(), Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(resourceUri)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MarvelItem> {
        override fun createFromParcel(parcel: Parcel): MarvelItem {
            return MarvelItem(parcel)
        }

        override fun newArray(size: Int): Array<MarvelItem?> {
            return arrayOfNulls(size)
        }
    }
}