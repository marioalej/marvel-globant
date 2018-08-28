package com.globant.mariorangel.domain.usecases.marvelcharacter

import android.util.Log
import com.globant.mariorangel.data.local.RealmDatabaseProvider
import com.globant.mariorangel.data.network.MarvelService
import com.globant.mariorangel.domain.UseCaseDisposables
import com.globant.mariorangel.models.MarvelCharacter
import com.globant.mariorangel.models.RootResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GetCharactersUseCase {

    fun fetchFromApi (listener: (List<MarvelCharacter>) -> Unit) {

        val databaseWrapper = RealmDatabaseProvider<MarvelCharacter>()

        UseCaseDisposables.addDisposable(MarvelService.getApi().getCharacters(50)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<RootResponse>() {
                    override fun onSuccess(t: RootResponse?) {
                        if(t?.data?.results == null)
                            return

                        databaseWrapper.daleteAll(MarvelCharacter::class.java)

                        for(item in t.data.results)
                            databaseWrapper.save(item)

                        listener(t.data.results)
                    }

                    override fun onError(e: Throwable?) {
                        Log.i("TAG", e!!.message!!)
                    }
                }))
    }
}
