package com.globant.mariorangel.models

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import org.parceler.Parcel
import org.parceler.Parcel.Serialization

@RealmClass
@Parcel(Serialization.BEAN, analyze = [CharacterUrl::class])
open class CharacterUrl : RealmObject() {
    @SerializedName("type") open var type: String? = ""
    @SerializedName("url") open var url: String? = ""
}
