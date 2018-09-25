package com.globant.mariorangel.data.local

interface RealmWrapper<T> {

    fun queryAll(clazz : Class<T>) : List<T>
    fun save(obj: T)
    fun daleteAll(clazz: Class<T>)
}