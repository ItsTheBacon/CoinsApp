package com.bacon.cryptocoin.di.subcomponents.coinsdetail

import com.bacon.cryptocoin.domain.usecases.FetchCoinDetailUseCase
import com.bacon.cryptocoin.presentation.ui.fragments.detail.CoinsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CoinsDetailModule {

    @CoinsDetailScope
    @Provides
    fun provideCoinsDetailModule(
        useCase: FetchCoinDetailUseCase,
    ): CoinsViewModelFactory {
        return CoinsViewModelFactory(
            useCase
        )
    }
}