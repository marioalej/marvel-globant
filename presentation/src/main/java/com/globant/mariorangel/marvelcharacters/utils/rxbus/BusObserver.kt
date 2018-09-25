package com.globant.mariorangel.marvelcharacters.utils.rxbus

import io.reactivex.functions.Consumer

@Suppress("UNCHECKED_CAST")
abstract class BusObserver<in T>(private val clazz: Class<T>) : Consumer<Any> {

    @Throws(Exception::class)
    override fun accept(value: Any) {
        if (value.javaClass == clazz) {
            onEvent(value as T)
        }
    }

    abstract fun onEvent(value: T)
}