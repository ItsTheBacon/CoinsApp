package com.bacon.cryptocoin.presentation.ui.fragments.home

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bacon.cryptocoin.common.base.BaseViewModel
import com.bacon.cryptocoin.data.repositories.CoinsRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: CoinsRepository
) : BaseViewModel() {

    fun fetchCoins() =
        repository.fetchCoins().cachedIn(viewModelScope)
}