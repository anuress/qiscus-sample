package com.astro.sample.code

import android.app.Application
import com.astro.sample.code.di.appModule
import com.qiscus.sdk.chat.core.QiscusCore
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SampleApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SampleApplication)
            modules(appModule)
        }

        QiscusCore.setup(this, "qddqt-bbtcrjaycsqldcp")
    }
}