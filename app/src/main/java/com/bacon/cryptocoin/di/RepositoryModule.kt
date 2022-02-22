package com.bacon.cryptocoin.di

import com.bacon.cryptocoin.data.remote.apiservices.CoinDetailApiService
import com.bacon.cryptocoin.data.remote.apiservices.CoinsApiService
import com.bacon.cryptocoin.data.repositories.CoinsDetailRepositoryImpl
import com.bacon.cryptocoin.data.repositories.CoinsRepositoryImpl
import com.bacon.cryptocoin.domain.repositories.CoinsDetailRepository
import com.bacon.cryptocoin.domain.repositories.CoinsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideCoinsRepositoryImpl(service: CoinsApiService): CoinsRepository {
        return CoinsRepositoryImpl(service)
    }

    @Provides
    fun provideCoinDetailRepositoryImpl(service: CoinDetailApiService): CoinsDetailRepository {
        return CoinsDetailRepositoryImpl(service)
    }
}