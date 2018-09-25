package com.globant.mariorangel.models.realmconverters

import android.os.Parcel
import com.globant.mariorangel.models.MarvelItem
import org.parceler.Parcels

class MarvelItemRealmListConverter : RealmListParcelConverter<MarvelItem>(){

    override fun itemFromParcel(parcel: Parcel?): MarvelItem {
        return Parcels.unwrap(parcel?.readParcelable(MarvelItem::class.java.classLoader))
    }

    override fun itemToParcel(input: MarvelItem?, parcel: Parcel?) {
        parcel?.writeParcelable(Parcels.wrap(input), 0)
    }
}