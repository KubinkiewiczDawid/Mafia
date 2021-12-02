package com.dawidk.mafia

import android.app.Application
import com.dawidk.mafia.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.GlobalContext

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidContext(this@MainApplication)
            fragmentFactory()
            modules(
                appModule
            )
        }
    }
}