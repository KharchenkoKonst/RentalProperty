package com.example.rentalproperty.app

import android.app.Application
import android.content.Context
import com.example.rentalproperty.BuildConfig
import com.example.rentalproperty.di.AppComponent
import com.example.rentalproperty.di.DaggerAppComponent
import timber.log.Timber

class MainApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }