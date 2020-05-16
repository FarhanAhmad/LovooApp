package com.black.lovooapp.common

import android.util.Log

/**
 * Created by farhanahmad on 16/5/20.
 */

object Logger {
    fun i(tag: String, msg: String) {
        Log.i(tag, msg)
    }

    fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }
}