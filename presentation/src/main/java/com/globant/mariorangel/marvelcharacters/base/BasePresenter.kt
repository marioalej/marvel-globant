package com.globant.mariorangel.marvelcharacters.base

import android.app.Activity
import com.globant.mariorangel.domain.UseCaseDisposables
import com.globant.mariorangel.marvelcharacters.utils.rxbus.RxBus

abstract class BasePresenter(protected val view: BaseView) {


    //Bind observers to Activity
    fun register() {

        val activity = view.activity
        if (activity != null) subscribeObservers(activity)
    }

    //Unbind observers to Activity
    fun unRegister() {
        val activity = view.activity ?: return

        RxBus.clear(activity)

        UseCaseDisposables.unSubscribe()
    }

    abstract fun subscribeObservers(activity: Activity)
}