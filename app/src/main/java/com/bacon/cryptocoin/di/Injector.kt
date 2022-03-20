package com.bacon.cryptocoin.di

import com.bacon.cryptocoin.di.subcomponents.CoinsSubComponent
import com.bacon.cryptocoin.di.subcomponents.coinsdetail.CoinsDetailSubComponent

interface Injector {
    fun createCoinsSubComponent(): CoinsSubComponent
    fun createCoinsDetailSubComponent(): CoinsDetailSubComponent
}