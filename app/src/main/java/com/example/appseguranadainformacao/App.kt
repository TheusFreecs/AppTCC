package com.example.appseguranadainformacao

import android.app.Application
import com.example.appseguranadainformacao.core.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        firstKoin()
    }

    private fun firstKoin() {
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                listOf(
                    viewModelModule,
                )
            )
        }
    }
}