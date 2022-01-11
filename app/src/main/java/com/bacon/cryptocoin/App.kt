package com.bacon.cryptocoin

import android.app.Application
import com.bacon.cryptocoin.di.AppComponent
import com.bacon.cryptocoin.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.create()
    }
}