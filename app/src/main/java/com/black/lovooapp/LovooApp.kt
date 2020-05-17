package com.black.lovooapp

import android.app.Application
import com.black.lovooapp.di.moduleList
import org.koin.android.ext.android.startKoin

/**
 * Created by farhanahmad on 16/5/20.
 */
class LovooApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, moduleList)
    }
}