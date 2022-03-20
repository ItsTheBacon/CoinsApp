package com.bacon.cryptocoin.di.subcomponents.coinsdetail

import com.bacon.cryptocoin.presentation.ui.fragments.detail.CoinsDetailFragment
import dagger.Subcomponent

@CoinsDetailScope
@Subcomponent(modules = [CoinsDetailModule::class])
interface CoinsDetailSubComponent {
    fun inject(fragment: CoinsDetailFragment)


    @Subcomponent.Factory
    interface Factory {
        fun create(): CoinsDetailSubComponent
    }
}