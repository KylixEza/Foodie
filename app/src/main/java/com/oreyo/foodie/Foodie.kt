package com.oreyo.foodie

import android.app.Application
import com.oreyo.foodie.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Foodie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Foodie)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    firebaseModule,
                    repositoryModule,
                    viewModelModule,
                )
            )
        }
    }
}