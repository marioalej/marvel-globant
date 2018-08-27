package com.globant.mariorangel.marvelcharacters.characters.view

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import com.globant.mariorangel.marvelcharacters.base.BaseView
import com.globant.mariorangel.marvelcharacters.characters.view.adapter.CharactersAdapter
import com.globant.mariorangel.models.MarvelCharacter
import kotlinx.android.synthetic.main.activity_characters.*

class CharactersView(activity: Activity) : BaseView(activity) {

    init {

    }

    fun initRecycler(list: List<MarvelCharacter>) {
        activity!!.recycler_characters.layoutManager = LinearLayoutManager(context)
        activity!!.recycler_characters.adapter = CharactersAdapter(list)
    }
}