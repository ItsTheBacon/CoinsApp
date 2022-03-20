package com.bacon.cryptocoin.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bacon.cryptocoin.domain.usecases.FetchCoinDetailUseCase
import javax.inject.Inject

class CoinsViewModelFactory @Inject constructor(
    private val useCase: FetchCoinDetailUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinsDetailViewModel::class.java)) {
            return CoinsDetailViewModel(useCase) as T
        }
        throw IllegalArgumentException("Cannot create view model for ${modelClass.name}")
    }
}

