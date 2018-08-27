package com.globant.mariorangel.marvelcharacters.characters.presenter

import android.app.Activity
import com.globant.mariorangel.marvelcharacters.base.BasePresenter
import com.globant.mariorangel.marvelcharacters.utils.rxbus.RxBus
import com.globant.mariorangel.marvelcharacters.characters.model.CharactersModel
import com.globant.mariorangel.marvelcharacters.characters.utils.bus.CallMarvelCharactersService
import com.globant.mariorangel.marvelcharacters.characters.view.CharactersView

class CharactersPresenter(private val model: CharactersModel,
                          private val sview: CharactersView) : BasePresenter(sview){

    override fun subscribeObservers(activity: Activity) {

    }

    fun loadCharacters() {
        model.getCharacters().fetchFromApi {
            sview.initRecycler(it)
        }
    }
}