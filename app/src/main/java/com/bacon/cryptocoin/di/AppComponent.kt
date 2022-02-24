package com.bacon.cryptocoin.di

import com.bacon.cryptocoin.common.factory.CoinsViewModelFactory
import com.bacon.cryptocoin.common.factory.ViewModelFactory
import com.bacon.cryptocoin.presentation.ui.fragments.detail.CoinsDetailFragment
import com.bacon.cryptocoin.presentation.ui.fragments.home.HomeFragment
import com.bacon.cryptocoin.presentation.ui.fragments.search.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, RepositoryModule::class])
@Singleton
interface AppComponent {
    fun viewModelsFactory(): ViewModelFactory
    fun coinsViewModelFactory(): CoinsViewModelFactory
    fun inject(fragment: CoinsDetailFragment)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: SearchFragment)
}