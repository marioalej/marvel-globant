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
        RxBus.subscribe(activity, object : CallMarvelCharactersService() {
            override fun onEvent(value: OnServiceInvoked) {
                loadCharacters()
            }
        })
    }

    fun loadCharacters() {
        sview.showProgressBar()
        model.getCharacters().fetchFromApi {
            sview.hideProgressBar()
            sview.initRecycler(it)
        }
    }
}