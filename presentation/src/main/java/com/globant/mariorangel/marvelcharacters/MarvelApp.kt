package com.globant.mariorangel.marvelcharacters

import android.app.Application
import com.globant.mariorangel.models.MarvelRealmModule
import io.realm.Realm
import io.realm.RealmConfiguration

class MarvelApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val realmConfiguration = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .modules(MarvelRealmModule())
                .build()

        Realm.setDefaultConfiguration(realmConfiguration)
    }
}