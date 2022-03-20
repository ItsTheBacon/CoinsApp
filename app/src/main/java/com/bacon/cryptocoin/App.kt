package com.bacon.cryptocoin

import android.app.Application
import com.bacon.cryptocoin.di.Injector
import com.bacon.cryptocoin.di.components.AppComponent
import com.bacon.cryptocoin.di.components.DaggerAppComponent
import com.bacon.cryptocoin.di.modules.AppModule
import com.bacon.cryptocoin.di.modules.NetworkModule
import com.bacon.cryptocoin.di.modules.RepositoryModule
import com.bacon.cryptocoin.di.subcomponents.CoinsSubComponent
import com.bacon.cryptocoin.di.subcomponents.coinsdetail.CoinsDetailSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initializeDagger()

    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
    }

    override fun createCoinsSubComponent(): CoinsSubComponent {
        return appComponent.coinsSubComponent().create()
    }

    override fun createCoinsDetailSubComponent(): CoinsDetailSubComponent {
        return appComponent.coinsDetailSubComponent().create()
    }
}