package com.globant.mariorangel.marvelcharacters.characters.model

import com.globant.mariorangel.domain.usecases.marvelcharacter.GetCharactersUseCase

class CharactersModel {

    private val getCharactersUseCase = GetCharactersUseCase()

    fun getCharacters() : GetCharactersUseCase {
       return getCharactersUseCase
    }
}