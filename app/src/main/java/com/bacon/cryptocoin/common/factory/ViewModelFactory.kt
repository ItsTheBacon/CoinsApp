package com.bacon.cryptocoin.common.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bacon.cryptocoin.presentation.ui.fragments.detail.CoinsDetailViewModel
import com.bacon.cryptocoin.presentation.ui.fragments.home.HomeViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<HomeViewModel>
) : ViewModelProvider.Factory {
    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        HomeViewModel::class.java to myViewModelProvider
    )


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}
class CoinsViewModelFactory @Inject constructor(
    viewModelModelProvider: Provider<CoinsDetailViewModel>
) : ViewModelProvider.Factory{
    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        CoinsDetailViewModel::class.java to viewModelModelProvider
    )
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }

}
