package com.globant.mariorangel.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject


open class MarvelComics(@SerializedName("available") var available: Int? = 0,
                        @SerializedName("collectionURI") var collectionUri: String? = "",
                        /*@SerializedName("items") var items: RealmList<MarvelItem>? = RealmList(),*/
                        @SerializedName("returned") var returned: Int? = 0) : RealmObject(), Parcelable {

    @Suppress("UNREACHABLE_CODE")
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(available)
        parcel.writeString(collectionUri)
        parcel.writeValue(returned)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MarvelComics> {
        override fun createFromParcel(parcel: Parcel): MarvelComics {
            return MarvelComics(parcel)
        }

        override fun newArray(size: Int): Array<MarvelComics?> {
            return arrayOfNulls(size)
        }
    }
}
