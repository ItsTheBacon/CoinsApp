package com.bacon.cryptocoin.di.components

import com.bacon.cryptocoin.di.modules.AppModule
import com.bacon.cryptocoin.di.modules.NetworkModule
import com.bacon.cryptocoin.di.modules.RepositoryModule
import com.bacon.cryptocoin.di.subcomponents.CoinsSubComponent
import com.bacon.cryptocoin.di.subcomponents.coinsdetail.CoinsDetailSubComponent
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])
@Singleton
interface AppComponent {
    fun coinsSubComponent(): CoinsSubComponent.Factory
    fun coinsDetailSubComponent() : CoinsDetailSubComponent.Factory
}