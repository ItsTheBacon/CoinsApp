package com.bacon.cryptocoin.presentation.ui.fragments.home

import com.bacon.cryptocoin.common.base.BaseViewModel
import com.bacon.cryptocoin.domain.usecases.FetchCoinsUseCase
import com.bacon.cryptocoin.presentation.models.CoinsItemUI
import com.bacon.cryptocoin.presentation.models.toUI
import com.bacon.cryptocoin.presentation.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCase: FetchCoinsUseCase,
) : BaseViewModel() {

    private val _fetchCoinsState = MutableStateFlow<UIState<List<CoinsItemUI>>>(UIState.Loading())
    val fetchCoinsState: StateFlow<UIState<List<CoinsItemUI>>> = _fetchCoinsState

    init {
        fetchCoins()
    }
    private fun fetchCoins() {
        _fetchCoinsState.subscribeTo({ useCase() },
            { it -> it.map { it.toUI() } })
    }
}