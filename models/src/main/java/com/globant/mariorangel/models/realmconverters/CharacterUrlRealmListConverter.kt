package com.globant.mariorangel.models.realmconverters

import android.os.Parcel
import com.globant.mariorangel.models.CharacterUrl
import org.parceler.Parcels

class CharacterUrlRealmListConverter : RealmListParcelConverter<CharacterUrl>() {

    override fun itemFromParcel(parcel: Parcel?): CharacterUrl {
        return Parcels.unwrap(parcel?.readParcelable(CharacterUrl::class.java.classLoader))
    }

    override fun itemToParcel(input: CharacterUrl?, parcel: Parcel?) {
        parcel?.writeParcelable(Parcels.wrap(input), 0)
    }
}