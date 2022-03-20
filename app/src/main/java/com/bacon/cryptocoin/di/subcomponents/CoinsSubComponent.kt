package com.bacon.cryptocoin.di.subcomponents

import com.bacon.cryptocoin.presentation.ui.fragments.home.HomeFragment
import dagger.Subcomponent

@CoinsScope
@Subcomponent(modules = [CoinsModule::class])
interface CoinsSubComponent {
    fun inject(fragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): CoinsSubComponent
    }
}