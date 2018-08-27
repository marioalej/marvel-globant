package com.globant.mariorangel.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class CharacterUrl(@SerializedName("type") var type: String? = "",
                   @SerializedName("url") var url: String? = "") : RealmObject(), Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterUrl> {
        override fun createFromParcel(parcel: Parcel): CharacterUrl {
            return CharacterUrl(parcel)
        }

        override fun newArray(size: Int): Array<CharacterUrl?> {
            return arrayOfNulls(size)
        }
    }
}
