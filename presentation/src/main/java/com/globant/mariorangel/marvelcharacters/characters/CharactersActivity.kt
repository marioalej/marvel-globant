package com.globant.mariorangel.marvelcharacters.characters

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.mariorangel.marvelcharacters.R
import com.globant.mariorangel.marvelcharacters.characters.model.CharactersModel
import com.globant.mariorangel.marvelcharacters.characters.presenter.CharactersPresenter
import com.globant.mariorangel.marvelcharacters.characters.view.CharactersView

class CharactersActivity : AppCompatActivity() {

    private lateinit var presenter: CharactersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        presenter = CharactersPresenter(CharactersModel(), CharactersView(this))
        presenter.loadCharacters()
    }

    override fun onResume() {
        super.onResume()

        presenter.register()
    }

    override fun onPause() {
        super.onPause()

        presenter.unRegister()
    }
}
