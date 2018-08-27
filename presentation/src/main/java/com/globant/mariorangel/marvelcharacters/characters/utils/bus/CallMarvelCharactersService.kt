package com.globant.mariorangel.marvelcharacters.characters.utils.bus

import com.globant.mariorangel.marvelcharacters.utils.rxbus.BusObserver

abstract class CallMarvelCharactersService :
        BusObserver<CallMarvelCharactersService.OnServiceInvoked>(OnServiceInvoked::class.java) {

    class OnServiceInvoked
}