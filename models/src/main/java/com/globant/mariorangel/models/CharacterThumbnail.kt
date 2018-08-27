package com.globant.mariorangel.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class CharacterThumbnail(@SerializedName("path") var path: String? = "",
                         @SerializedName("extension") var extension: String? = "") : RealmObject(), Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(path)
        parcel.writeString(extension)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterThumbnail> {
        override fun createFromParcel(parcel: Parcel): CharacterThumbnail {
            return CharacterThumbnail(parcel)
        }

        override fun newArray(size: Int): Array<CharacterThumbnail?> {
            return arrayOfNulls(size)
        }
    }
}