package com.bacon.cryptocoin.di.modules

import android.content.Context
import com.bacon.cryptocoin.di.subcomponents.CoinsSubComponent
import com.bacon.cryptocoin.di.subcomponents.coinsdetail.CoinsDetailSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        CoinsSubComponent::class,
        CoinsDetailSubComponent::class
    ]
)
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}