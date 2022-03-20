package com.bacon.cryptocoin.di.subcomponents

import com.bacon.cryptocoin.domain.usecases.FetchCoinsUseCase
import com.bacon.cryptocoin.presentation.ui.fragments.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CoinsModule {

    @CoinsScope
    @Provides
    fun provideCoinsViewModelFactory(
        useCase: FetchCoinsUseCase,
    ): HomeViewModelFactory {
        return HomeViewModelFactory(
            useCase
        )
    }
}