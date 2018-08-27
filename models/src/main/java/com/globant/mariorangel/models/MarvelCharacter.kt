package com.globant.mariorangel.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class MarvelCharacter(@SerializedName("id") @PrimaryKey var id: Long? = 0,
                           @SerializedName("name") var name: String? = "",
                           @SerializedName("description") var description: String? = "",
                           @SerializedName("modified") var modified: String? = "",
                           @SerializedName("thumbnail") var thumbnail: CharacterThumbnail? = CharacterThumbnail(),
                           @SerializedName("resourceURI") var resourceUri: String? = "",
                           @SerializedName("comics") var comics: MarvelComics? = MarvelComics(),
                           @SerializedName("series") var series: MarvelSeries? = MarvelSeries(),
                           @SerializedName("stories") var stories: MarvelStories? = MarvelStories(),
                           @SerializedName("events") var events: MarvelEvents? = MarvelEvents()
                           /*@SerializedName("urls") var urls: RealmList<CharacterUrl>? = RealmList()*/)
    : RealmObject(), Parcelable {

    @Suppress("UNREACHABLE_CODE")
    constructor(parcel: Parcel) : this(
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(CharacterThumbnail::class.java.classLoader),
            parcel.readString(),
            parcel.readParcelable(MarvelComics::class.java.classLoader),
            parcel.readParcelable(MarvelSeries::class.java.classLoader),
            parcel.readParcelable(MarvelStories::class.java.classLoader),
            parcel.readParcelable(MarvelEvents::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(modified)
        parcel.writeParcelable(thumbnail, flags)
        parcel.writeString(resourceUri)
        parcel.writeParcelable(comics, flags)
        parcel.writeParcelable(series, flags)
        parcel.writeParcelable(stories, flags)
        parcel.writeParcelable(events, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MarvelCharacter> {
        override fun createFromParcel(parcel: Parcel): MarvelCharacter {
            return MarvelCharacter(parcel)
        }

        override fun newArray(size: Int): Array<MarvelCharacter?> {
            return arrayOfNulls(size)
        }
    }
}