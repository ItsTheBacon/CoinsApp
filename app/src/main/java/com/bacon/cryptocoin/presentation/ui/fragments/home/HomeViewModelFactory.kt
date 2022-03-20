package com.bacon.cryptocoin.presentation.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bacon.cryptocoin.domain.usecases.FetchCoinsUseCase
import javax.inject.Inject


class HomeViewModelFactory @Inject constructor(
    private val useCase: FetchCoinsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(useCase) as T
        }

        throw IllegalArgumentException("Cannot create view model for ${modelClass.name}")
    }
}
