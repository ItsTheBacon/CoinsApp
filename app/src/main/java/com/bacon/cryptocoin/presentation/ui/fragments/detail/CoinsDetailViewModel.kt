package com.bacon.cryptocoin.presentation.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bacon.cryptocoin.common.base.BaseViewModel
import com.bacon.cryptocoin.data.remote.dtos.CoinsDto
import com.bacon.cryptocoin.data.repositories.CoinsDetailRepository
import com.bacon.cryptocoin.presentation.state.UIState
import javax.inject.Inject

class CoinsDetailViewModel @Inject constructor(
    private val repository: CoinsDetailRepository
) : BaseViewModel() {

    private val _fetchCoinDetail = MutableLiveData<UIState<CoinsDto>>()
    val fetchCoinsDetail: LiveData<UIState<CoinsDto>> = _fetchCoinDetail

    fun fetchCoinDetail(id:String){
        subscribeTo(_fetchCoinDetail){
            repository.fetchCoinDetail(id)
        }
    }

}