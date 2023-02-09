package io.kobby.mergdataapp

import android.app.Application
import io.kobby.mergdataapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class MainApplication :Application(){
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidContext(this@MainApplication)
            modules(appModule)
        }
    }
}