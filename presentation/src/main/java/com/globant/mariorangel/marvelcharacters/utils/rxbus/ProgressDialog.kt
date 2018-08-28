package com.globant.mariorangel.marvelcharacters.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.view.Window
import com.globant.mariorangel.marvelcharacters.R


class ProgressDialog : Dialog {

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, themeResId: Int) : super(context, themeResId) {
        initView()
    }

    private constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener) : super(context, cancelable, cancelListener) {
        initView()
    }

    private fun initView() {
        hideDialogTitleBar()
        setContentView(R.layout.loading_dialog)
    }

    private fun hideDialogTitleBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            window?.requestFeature(Window.FEATURE_NO_TITLE)
        }
    }
}