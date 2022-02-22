package com.bacon.cryptocoin.presentation.ui.fragments.detail

import com.bacon.cryptocoin.common.base.BaseViewModel
import com.bacon.cryptocoin.domain.usecases.FetchCoinDetailUseCase
import com.bacon.cryptocoin.presentation.models.CoinDetailUI
import com.bacon.cryptocoin.presentation.models.toUI
import com.bacon.cryptocoin.presentation.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class CoinsDetailViewModel @Inject constructor(
    private val useCase: FetchCoinDetailUseCase,
) : BaseViewModel() {

    private val _fetchCoinDetail = MutableStateFlow<UIState<List<CoinDetailUI>>>(UIState.Loading())
    val fetchCoinsDetail: StateFlow<UIState<List<CoinDetailUI>>> = _fetchCoinDetail

    fun fetchCoinDetail(id: String) {
        _fetchCoinDetail.subscribeTo({
            useCase(id)
        }, { it ->
            it.map {
                it.toUI()
            }
        })
    }

}