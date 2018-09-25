package com.globant.mariorangel.domain

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

object UseCaseDisposables {

    private var compositeDisposable = CompositeDisposable()

    fun unSubscribe() { compositeDisposable.clear() }

    fun addDisposable(d: Disposable) {
        compositeDisposable.add(d)
    }
}