package com.globant.mariorangel.marvelcharacters.base

import android.app.Activity
import android.content.Context
import com.globant.mariorangel.marvelcharacters.utils.ProgressDialog
import java.lang.ref.WeakReference

@Suppress("DEPRECATION")
abstract class BaseView(activity: Activity) {

    private val activityRef: WeakReference<Activity> = WeakReference(activity)

    val activity: Activity?
        get() = activityRef.get()

    val context: Context?
        get() = activity

    val fragmentManager: android.app.FragmentManager?
        get() {
            val activity = activity
            return activity?.fragmentManager
        }

    private var progressDialog = ProgressDialog(context!!)

    fun hideProgressBar() {
        progressDialog.hide()
    }

    fun showProgressBar() {
        progressDialog.show()
    }
}